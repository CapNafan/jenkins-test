package org.example.utility;

import java.io.FileReader;
import java.io.IOException;

import org.example.Constants;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonLoader {

    private static JSONObject loadJsonFromFile() {
        String testDataPath = Constants.TEST_DATA_PATH;
        Object obj;
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader filereader = new FileReader(testDataPath);
            obj = jsonParser.parse(filereader);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        return (JSONObject) obj;
    }

    public static JSONArray getExpectedLanguages() {
        JSONObject json = loadJsonFromFile();
        return (JSONArray) json.get("languages");
    }

    public static int getExpectedWindowCount() {
        JSONObject json = loadJsonFromFile();
        Long count = (Long) json.get("expectedWindowCount");
        return count.intValue();
    }

    public static String getExpectedNoPostsText() {
        JSONObject json = loadJsonFromFile();
        return json.get("noPostsLabel").toString();
    }
}
