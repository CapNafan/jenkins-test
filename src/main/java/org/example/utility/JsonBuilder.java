package org.example.utility;

import org.json.simple.JSONArray;

import java.util.List;

public class JsonBuilder {

    public static JSONArray buildJsonFromLanguagesList(List<String> languageList) {
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(languageList);
        return jsonArray;
    }
}
