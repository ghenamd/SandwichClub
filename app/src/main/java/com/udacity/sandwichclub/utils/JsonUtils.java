package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class JsonUtils {

    private static final String sName = "name";
    private static final String sMainName = "mainName";
    private static final String sAlsoKnownAs = "alsoKnownAs";
    private static final String sPlaceOfOrigin = "placeOfOrigin";
    private static final String sDescription = "description";
    private static final String sImage = "image";
    private static final String sIngredients = "ingredients";


    public static Sandwich parseSandwichJson(String json) throws JSONException {

        try {
            JSONObject mainObject = new JSONObject(json);
            JSONObject name = mainObject.getJSONObject(sName);

            String mainName = name.getString(sMainName);

            ArrayList<String> alsoKnowAsArray = new ArrayList<>();
            JSONArray array = name.getJSONArray(sAlsoKnownAs);
            for (int i = 0; i <array.length() ; i++) {
                alsoKnowAsArray.add(array.getString(i));
            }

            String origin = mainObject.getString(sPlaceOfOrigin);

            String description = mainObject.getString(sDescription);

            String image = mainObject.getString(sImage);

            ArrayList<String> ingredientsArray = new ArrayList<>();
            JSONArray array1 = mainObject.getJSONArray(sIngredients);
            for (int i = 0; i <array1.length() ; i++) {
                ingredientsArray.add(array1.getString(i));
            }

            return new Sandwich(mainName,alsoKnowAsArray,origin,description,image,ingredientsArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
