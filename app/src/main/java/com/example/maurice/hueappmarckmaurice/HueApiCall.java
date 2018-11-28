package com.example.maurice.hueappmarckmaurice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class HueApiCall{

    Context context;
    RequestQueue queue;
    HueListner listener;
    private String basicUrl;
    private String username;


    public HueApiCall(Context context, HueListner listener, String ipAdress) {

        this.context = context;
        queue = Volley.newRequestQueue(context);
        this.listener = listener;
        this.basicUrl = "https://"+ipAdress+"/api";

    }


    public void HandleAPICall(CallType type, @Nullable String lightID, @Nullable JSONObject body)
    {
        switch(type)
        {
            case GET_USERNAME:
                getUserName();
                break;
            case GET_ALL_LIGHTS:
                getAllLights();
                break;
            case SET_ALL_LIGHTS:
                setAllLights();
                break;
            case GET_SINGLE_LIGHT:
                getSingleLight(lightID);
                break;
            case SET_SINGLE_LIGHT:
                setSingleLight(lightID, body);
                break;
            default:break;
        }
    }

    private void getSingleLight(@Nullable String lightID)
    {
        String url = basicUrl + "/lights/" + lightID;
        LightsJSONObjectRequest singleLightRequest = new LightsJSONObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        Log.i("tag", "msg");
                           // Lamp lamp = new Lamp(response);
                    }
                },
                null
        );
    }

    private void setSingleLight(String lightID, JSONObject body)
    {

    }

    private void setAllLights()
    {
    }

    private void getAllLights()
    {
        String url = basicUrl + "/lights";
        LightsJSONObjectRequest lightsRequest = new LightsJSONObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        Log.i("tag", "msg");
                        //TODO: Shit laten weten dat er lichtjes zijn gekomen
                    }
                },
                null
        );
    }

    private void addUsernameToString()
    {
        basicUrl += "/" + this.username;
    }
    private void getUserName()
    {
        if(username == null)
        {
            Random random = new Random();
            String deviceName = "HUEAPPMarckMaurice#"+ Integer.toString(random.nextInt(999999999));
            JSONObject body = new JSONObject();
            try
            {
                body.put("devicetype", deviceName);
            } catch (JSONException e)
            {
                e.printStackTrace();
            }

            LightsJSONArrayRequest usernameRequest = new LightsJSONArrayRequest(
                    Request.Method.POST,
                    basicUrl,
                    body,
                    new Response.Listener<JSONArray>()
                    {
                        @Override
                        public void onResponse(JSONArray response)
                        {
                            Log.i("NRA", response.toString());
                            try
                            {
                                JSONObject succes = response.getJSONObject(0).getJSONObject("succes");
                                String uname = succes.getString("username");
                                listener.onUserNameAvailable(uname);
                            } catch (JSONException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    },
                    null
            );
        }
    }

    public void setUsername(String username)
    {
        this.username = username;
        addUsernameToString();
    }









//    public void getApiArray(){
//
//        String url = "https://api.blindwalls.gallery/apiv2/murals";
//        JsonArrayRequest request = new JsonArrayRequest(
//                Request.Method.GET,
//                url,
//                null,
//
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray blindWalls) {
//                        Log.i("NRA",blindWalls.toString());
//
//                        try {
//
//                            for( int i = 0; i < blindWalls.length(); i++) {
//
//                                JSONObject blindWallJSON = blindWalls.getJSONObject(i);
//                                BlindWall blindWall = new BlindWall(blindWallJSON);
//
//                                listener.onBlindWallAvailable(blindWall);
//
//
//                                Log.d("VOLLEY_TAG", blindWall.toString());
//                            }
//
//
//                        } catch (JSONException e1) {
//                            e1.printStackTrace();
//                        }
//
//
//                    }
//                },
//
//                new Response.ErrorListener() {
//
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.i("NRA","NOT OK");
//                        //listener.onBlindWallError(error.toString());
//
//                    }
//
//                }
//
//        );
//
//        this.queue.add(request);
//    }
}