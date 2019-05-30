package com.chameleon.selenium.web.chromeDevTool;

import org.apache.commons.codec.binary.Base64;

import com.accuweather.glacier.LocationData;

public class ChromeDevToolCommands {

    public static String emulationCanEmulate() {
        return "{\"id\":1,\"method\":\"Emulation.canEmulate\"}";
    }

    public static String emulationGeoLocationMessage(String latitude, String longitude) {
        return String.format("{\"id\":2,\"method\":\"Emulation.setGeolocationOverride\",\"params\":{\"latitude\":%s,\"longitude\":%s,\"accuracy\":100}}", latitude, longitude);

    }

    public static String emulationGeoLocationMessage(double latitude, double longitude) {
        return String.format("{\"id\":2,\"method\":\"Emulation.setGeolocationOverride\",\"params\":{\"latitude\":%s,\"longitude\":%s,\"accuracy\":100}}", latitude, longitude);
    }

    public static String emulationGeoLocationMessage(LocationData location) {
        return String.format("{\"id\":2,\"method\":\"Emulation.setGeolocationOverride\",\"params\":{\"latitude\":%s,\"longitude\":%s,\"accuracy\":100}}", location.getLatitude(), location.getLongitude());
    }

    public static String invalidCommand() {
        return "{\"id\":4,\"method\":\"Network.setRequestInterceptionEnabled\",\"params\":{\"enabled\":true}}";
    }

    public static String networkEnableMessage() {
        return "{\"id\":3,\"method\":\"Network.enable\",\"params\":{\"maxTotalBufferSize\":10000000,\"maxResourceBufferSize\":5000000}}";

    }

    public static String networkSetRequestInterceptorPatternMessage(String pattern, String documentType) {
        return String.format("{\"id\":4,\"method\":\"Network.setRequestInterception\",\"params\":{\"patterns\":[{\"urlPattern\":\"%s\",\"resourceType\":\"%s\"}]}}", pattern, documentType);

    }

    public static String networkBasicHttpAuthenticationMessage(String username, String password) {
        byte[] encodedBytes = Base64.encodeBase64(String.format("%s:%s", username, password).getBytes());
        String base64EncodedCredentials = new String(encodedBytes);
        return String.format("{\"id\":5,\"method\":\"Network.setExtraHTTPHeaders\",\"params\":{\"headers\":{\"Authorization\":\"Basic %s\"}}}", base64EncodedCredentials);
    }

}
