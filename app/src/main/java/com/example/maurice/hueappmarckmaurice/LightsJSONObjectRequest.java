package com.example.maurice.hueappmarckmaurice;

import android.support.annotation.Nullable;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class LightsJSONObjectRequest extends JsonRequest<JSONObject>
{
    public LightsJSONObjectRequest(int method, String url, @Nullable JSONObject requestBody,
                                    Response.Listener<JSONObject> listener,
                                    @Nullable Response.ErrorListener errorListener)
    {
        super(method,
                url,
                requestBody.toString(),
                listener,
                errorListener);


    }


    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response)
    {
        Response parsingResult;
        try
        {
            String responseText = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
            JSONObject returnObject = new JSONObject(responseText);
            parsingResult = Response.success(returnObject, HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException | JSONException e)
        {
           parsingResult = Response.error(new VolleyError("Geen JSONObject teruggekregen"));
        }

        return parsingResult;
    }
}
