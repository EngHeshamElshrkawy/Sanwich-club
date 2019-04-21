package com.udacity.sandwichclub.utils;

import android.widget.LinearLayout;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject jsonObject = new JSONObject(json);
        JSONObject nameObject = jsonObject.getJSONObject("name");
        String mainName = nameObject.getString("mainName");
        JSONArray nameArray = nameObject.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAs= new ArrayList<String>();
        for(int i = 0; i < nameArray.length(); i++)
            alsoKnownAs.add(nameArray.getString(i));

        String placeOfOrigin = jsonObject.getString("placeOfOrigin");
        String description = jsonObject.getString("description");
        String image = jsonObject.getString("image");
        JSONArray ingredientsArray = jsonObject.getJSONArray("ingredients");
        List<String> ingredients = new ArrayList<String>();
        for(int i = 0; i < ingredientsArray.length(); i++)
            ingredients.add(ingredientsArray.getString(i));


        Sandwich sandwich;
        sandwich = new Sandwich(mainName,alsoKnownAs, placeOfOrigin, description, image, ingredients);
        return sandwich;
    }
}
