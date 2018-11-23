package com.example.maurice.hueappmarckmaurice;

import android.media.Image;

public class Lamp
{
    private int lampId;
    private Image lampImage;
    private String description;

    public Lamp(Image lampImage, String description, int lampId)
    {
        setLampImage(lampImage);
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

    public Image getLampImage()
    {
        return lampImage;
    }

    public void setLampImage(Image lampImage)
    {
        this.lampImage = lampImage;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }


}
