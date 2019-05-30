package com.chameleon.selenium.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.json.JSONObject;
import org.openqa.selenium.BuildInfo;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.chameleon.AutomationException;
import com.chameleon.selenium.ExtendedDriver;

public class WebException extends AutomationException {

    private ExtendedDriver driver = null;

    private static final long serialVersionUID = -8710980695994382082L;

    public WebException(String message) {
        super(message);
    }

    public WebException(String message, ExtendedDriver driver) {
        super(message);
        this.driver = driver;
    }

    public WebException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return createMessage(super.getMessage());
    }

    private String createMessage(String originalMessageString) {
        String supportMessage = getSupportUrl() == null ? "" : "For documentation on this error, please visit: " + getSupportUrl() + "\n";

        return (originalMessageString == null ? "" : originalMessageString + "\n")
                + supportMessage
                + getBuildInformation() + "\n"
                + getDriverInfo(driver) + "\n"
                + getGridInfo(driver);
    }

    public String getSupportUrl() {
        return null;
    }

    public BuildInfo getBuildInformation() {
        return new BuildInfo();
    }

    public String getDriverInfo(final ExtendedDriver driver) {
        String browserName = "N/A";
        String browserVersion = "N/A";
        String osInfo = "N/A";
        String sessionId = "N/A";

        if (driver != null) {
            browserName = driver.getDriverCapability().browserName();
            browserVersion = driver.getDriverCapability().browserVersion();
            osInfo = driver.getDriverCapability().platformOS();
            sessionId = driver.getSessionId();
        }

        return String.format("Browser info: name: '%s', version: '%s', os.info: '%s', driver session id: '%s'",
                browserName,
                browserVersion,
                osInfo,
                sessionId).trim();
    }

    public String getGridInfo(ExtendedDriver driver) {
        String info = "Selenium Node info: N/A";
        String[] gridNodeInfo = null;

        if (driver != null) {
            gridNodeInfo = getHostNameAndPort(driver);

            info = String.format("Selenium Node info: hostname: '%s', port: '%s', session id: '%s'",
                    gridNodeInfo[0],
                    gridNodeInfo[1],
                    gridNodeInfo[2] == "N/A" ? driver.getSessionId() : gridNodeInfo[2]).trim();
        }
        return info;
    }

    private String[] getHostNameAndPort(ExtendedDriver driver) {
        String[] hostAndPort = new String[3];
        String sessionId = "N/A";

        if (driver == null) {
            return new String[] { "N/A", "N/A", "N/A" };
        }

        URL hostURL = ((HttpCommandExecutor) ((RemoteWebDriver) driver.getWebDriver()).getCommandExecutor()).getAddressOfRemoteServer();

        if (hostURL.getHost().contains("localhost")) {
            return new String[] { "N/A", "N/A", "N/A" };
        }

        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            String hostName = (hostURL.getHost());
            int port = 4444;
            HttpHost host = new HttpHost(hostName, port);
            sessionId = driver.getSessionId();
            URL sessionURL = new URL("http://" + hostName + ":" + port + "/grid/api/testsession?session=" + sessionId);
            BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("POST", sessionURL.toExternalForm());
            HttpResponse response = client.execute(host, r);
            JSONObject object = extractObject(response);
            URL myURL = new URL(object.getString("proxyId"));
            if ((myURL.getHost() != null) && (myURL.getPort() != -1)) {
                hostAndPort[0] = myURL.getHost();
                hostAndPort[1] = Integer.toString(myURL.getPort());
                hostAndPort[2] = sessionId;
            }
        } catch (Exception throwAway) {
            return new String[] { "N/A", "N/A", "N/A" };
        }

        return hostAndPort;
    }

    private static JSONObject extractObject(HttpResponse resp) throws IOException {
        StringBuilder s = new StringBuilder();
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()))) {
            String line;
            while ((line = rd.readLine()) != null) {
                s.append(line);
            }
        }
        return new JSONObject(s.toString());
    }
}
