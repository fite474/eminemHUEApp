package com.example.maurice.hueappmarckmaurice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button emulatorButton;
    Button bridgeButton;
    TextView portTxt;
    TextView ipTxt;
    EditText portInputText;
    EditText ipInputText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emulatorButton = (Button) findViewById(R.id.emulatorButton);
        portInputText = (EditText) findViewById(R.id.portInputText);
        //String portNmr = "";
                emulatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String portNmr = portInputText.getText().toString();
                Intent intent = new Intent(
                        getApplicationContext(),
                        DetailActivity.class
                );

                intent.putExtra("isEmulator", true);

                intent.putExtra("portNumber", portNmr);


                startActivity(intent);
            }
        });

        bridgeButton = (Button) findViewById(R.id.bridgeButton);
        ipInputText = (EditText) findViewById(R.id.ipTextInput);

        bridgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ipNmr = ipInputText.getText().toString();
                Intent intent = new Intent(
                        getApplicationContext(),
                        DetailActivity.class
                );


                intent.putExtra("isEmulator", false);

                intent.putExtra("ipNumber", ipNmr);


                startActivity(intent);
            }
        });



    }
}
