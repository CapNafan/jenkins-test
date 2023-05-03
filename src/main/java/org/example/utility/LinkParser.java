package org.example.utility;


public class LinkParser {

    public static String getLanguageFromUri(String uriString) {
        if (uriString.endsWith("/")) {
            uriString = uriString.substring(0, uriString.length() - 1);
        }
        return uriString.substring(uriString.lastIndexOf('/') + 1);
    }
}
