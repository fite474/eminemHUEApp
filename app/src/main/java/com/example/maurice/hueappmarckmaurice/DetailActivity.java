package com.example.maurice.hueappmarckmaurice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    TextView activityVersionTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamps);

        activityVersionTxt = (TextView) findViewById(R.id.activityVersionTxt);

        Intent intent = getIntent();
        boolean isEmulator = intent.getExtras().getBoolean("isEmulator");


        if(isEmulator)
        {

            String portNumber = intent.getExtras().getString("portNumber");
            //String portNumber = Objects.requireNonNull(intent.getExtras()).getString("portNumber");
            String appSetting = "Heu emulator";

            activityVersionTxt.setText(appSetting);

        }
        else
        {
            String ipNumber = intent.getExtras().getString("ipNumber");
            //String portNumber = Objects.requireNonNull(intent.getExtras()).getString("portNumber");
            String appSetting = "Brige";

            activityVersionTxt.setText(appSetting);
        }





    }
}
