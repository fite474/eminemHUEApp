package com.example.maurice.hueappmarckmaurice;

import android.content.Context;
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

    public void addUsernameToString()
    {
        
    }
    private String getUserName()
    {

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