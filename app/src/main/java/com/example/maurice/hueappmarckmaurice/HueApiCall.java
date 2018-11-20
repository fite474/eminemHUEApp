package com.example.maurice.hueappmarckmaurice;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class HueApiCall{

    Context context;
    RequestQueue queue;
    HueListner listener;

    public HueApiCall(Context context, HueListner listener) {

        this.context = context;
        queue = Volley.newRequestQueue(context);
        this.listener = listener;
    }

}