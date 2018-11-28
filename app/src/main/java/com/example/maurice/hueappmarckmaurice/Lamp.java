package com.example.maurice.hueappmarckmaurice;

import android.media.Image;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Lamp implements Serializable
{
    private int lampId;
    //private Image lampImage;
    private String description;


    public Lamp(JSONObject jsonWall) {

        try {

            // parse basic information:
            lampId =  jsonWall.getInt("id");
            //lampImage = jsonWall.getJSONObject("title").getString("en");
            description = jsonWall.getString("author").trim();



//            JSONArray imagesUrl = jsonWall.getJSONArray("images");
//            imagesUrls = new ArrayList<>();
//            for (int j = 0; j < imagesUrl.length(); j++) {
//                String imageUrl = "https://api.blindwalls.gallery/" + imagesUrl.getJSONObject(j).getString("url");
//                imagesUrls.add(imageUrl);
//            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public Lamp(Image lampImage, String description, int lampId)
    {
        //setLampImage(lampImage);
        setDescription(description);
        setLampId(lampId);
    }

    public Lamp(String imageurl, String description, int lampId)
    {
        //TODO:convert url to image
        setDescription(description);
        setLampId(lampId);

    }

    public int getLampId()
    {
        return lampId;
    }

    private void setLampId(int id)
    {
        this.lampId = id;
    }

//    public Image getLampImage()
//    {
//        return lampImage;
//    }

//    public void setLampImage(Image lampImage)
//    {
//        this.lampImage = lampImage;
//    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }


}
