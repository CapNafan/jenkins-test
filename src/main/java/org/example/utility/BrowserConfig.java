package org.example.utility;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Constants;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class BrowserConfig {

    private static final JsonNode rootNode;

    static {
        String pathToConfig = Constants.CONFIG_PATH;
        ObjectMapper mapper = new ObjectMapper();
        try {
            rootNode = mapper.readTree(new File(pathToConfig));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getStartUrl() {
        return rootNode.get("startUrl").asText();
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        JsonNode browserOptionsNode = rootNode.get("browserOptions");
        for (JsonNode optionNode : browserOptionsNode) {
            String option = optionNode.asText();
            options.addArguments(option);
        }
        return options;
    }

    public static Integer getExplicitWaitInSeconds() {
        return rootNode.get("timeout").asInt();
    }
}
