package com.example.maurice.hueappmarckmaurice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;


public class DetailActivity extends AppCompatActivity implements HueListner{

    TextView activityVersionTxt;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Lamp> lamps;
    private HueApiCall api;

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
            String appSetting = "";//"Heu_emulator";

            activityVersionTxt.setText(appSetting);

        }
        else
        {
            String ipNumber = intent.getExtras().getString("ipNumber");
            //String portNumber = Objects.requireNonNull(intent.getExtras()).getString("portNumber");
            String appSetting = "";//"Brige";

            activityVersionTxt.setText(appSetting);
        }


        //lamps = new ArrayList<>();


        //mAdapter = new MyAdapter(lamps);


        HueApiCall api = new HueApiCall(
                this.getApplicationContext(),
                this,
                "localhost:8000");
        api.HandleAPICall(CallType.GET_USERNAME, null, null);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewList);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        //mLayoutManager = new LinearLayoutManager(this);
        //mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        mAdapter = new MyAdapter(getApplicationContext(), lamps, this);
        mRecyclerView.setAdapter(mAdapter);

       // mRecyclerView.setOnContextClickListener();
//        mRecyclerView.setOnClickListener(new AdapterView.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(
//                        getApplicationContext(),
//                        LampSettingsActivity.class
//                );
//
//
//                startActivity(intent);
//            }
//
//        });

    }




    @Override
    public void onLampAvailable(Lamp lamp) {
        Log.i("", "");
        lamps.add(lamp);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLampWallError(String errorString) {

    }

    @Override
    public void onUserNameAvailable(String userName)
    {
        api.setUsername(userName);
    }

    @Override
    public void onAllLampsAvailable(ArrayList<Lamp> lamps)
    {

    }
}
