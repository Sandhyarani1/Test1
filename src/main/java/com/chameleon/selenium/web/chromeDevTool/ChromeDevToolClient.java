package com.chameleon.selenium.web.chromeDevTool;

import static com.chameleon.selenium.DriverConstants.CHROME_LOG_LOCATION;
import static com.chameleon.selenium.DriverConstants.MILLISECONDS_TO_WAIT_CHROME_DEVTOOLS;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.exceptions.ChromeDevToolException;
import com.chameleon.utils.TestReporter;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;

public class ChromeDevToolClient {
    private String webSocketDebuggerUrl = null;
    private WebSocket websocket = null;
    private String exceptionMessage = null;
    private final Object waitCoordinator = new Object();

    private ChromeDevToolClient() {

    }

    public static ChromeDevToolClient getInstance() {
        return new ChromeDevToolClient();
    }

    public void sendMessage(String message) {
        if (webSocketDebuggerUrl == null) {
            setWebSocketDebuggerUrl();
        }

        if (websocket == null) {
            try {
                websocket = new WebSocketFactory()
                        .createSocket(webSocketDebuggerUrl)
                        .addListener(new WebSocketAdapter() {
                            @Override
                            public void onTextMessage(WebSocket ws, String response) {
                                synchronized (waitCoordinator) {
                                    if (new JSONObject(response).has("error")) {
                                        exceptionMessage = response;
                                    }
                                    waitCoordinator.notifyAll();
                                }
                            }
                        })
                        .connect();
            } catch (IOException e) {
                throw new ChromeDevToolException("Failed to parse WebSocket response");
            } catch (WebSocketException e) {
                throw new ChromeDevToolException("Failed to open WebSocket");
            }
        }

        TestReporter.logTrace(message);
        websocket.sendText(message);

        synchronized (waitCoordinator) {
            try {
                waitCoordinator.wait(MILLISECONDS_TO_WAIT_CHROME_DEVTOOLS);
            } catch (InterruptedException e) {
                throw new ChromeDevToolException("No response from Chrome DevTools", e);
            }
            if (exceptionMessage != null) {
                throw new ChromeDevToolException(exceptionMessage);
            }
        }
    }

    public void close() {
        if (websocket != null) {
            websocket.sendClose();
            websocket = null;
        }
    }

    private void setWebSocketDebuggerUrl() {
        File file = DriverManager.getLogFile();
        try {
            Scanner sc = new Scanner(file);
            String urlString = null;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("DevTools HTTP Request: http://localhost")) {
                    urlString = line.substring(line.indexOf("http"), line.length()).replace("/version", "");
                    break;
                }
            }
            sc.close();

            if (urlString == null) {
                throw new ChromeDevToolException("Failed to find DevTools localhost url");
            }

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String json = IOUtils.toString(reader);
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.getString("type").equals("page")) {
                    webSocketDebuggerUrl = jsonObject.getString("webSocketDebuggerUrl");
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new ChromeDevToolException("Failed to find chromedriver.log on path [ " + CHROME_LOG_LOCATION + " ]. Ensure DriverContants.ENABLE_CHROME_LOGS is TRUE", e);
        } catch (IOException e) {
            throw new ChromeDevToolException("Failed to read chromedriver.log on path [ " + CHROME_LOG_LOCATION + " ]", e);
        }

        if (isEmpty(webSocketDebuggerUrl)) {
            throw new ChromeDevToolException("Failed to find DevTools WebSocket URL within chromedriver.log");
        }
    }
}
