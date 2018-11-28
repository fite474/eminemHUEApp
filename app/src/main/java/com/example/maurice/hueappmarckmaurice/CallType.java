package com.example.maurice.hueappmarckmaurice;

public enum CallType
{
    GET_USERNAME, GET_ALL_LIGHTS, GET_SINGLE_LIGHT, SET_SINGLE_LIGHT, SET_ALL_LIGHTS
}

/*
Get Username:
            POST request, url: https://IP-adres/api/ + body :
                                                               {
                                                                    "devicename":"MijnApp#DeviceNaam"
                                                               }


GET_ALL_LIGHTS:
            GET request, url: https://IP-adres/api/jouwusername/lights
            returnt een JSONObject met alle lampen


SET_ALL_LIGHTS:
            geen idee actually


GET_SINGLE_LIGHT:
            GET request, url: https://IP-adres/api/jouwusername/lights/id
            returnt een JSONObject van een lamp


SET_SINGLE_LIGHT:
            PUT request, url: https://IP-adres/api/jouwusername/lights/id/state
                                        met body:
                                                {
                                                  "on": bool
                                                  "bri": int
                                                  "hue": int
                                                  "sat": int
                                                 }              zijn gewoon voorbeelden


 */
