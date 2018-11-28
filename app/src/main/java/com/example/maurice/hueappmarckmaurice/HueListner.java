package com.example.maurice.hueappmarckmaurice;

import java.util.ArrayList;

import android.view.View;

public interface HueListner {
    public void onLampAvailable(Lamp lamp);
    public void onLampWallError(String errorString);
    void onUserNameAvailable(String userName);
    void onAllLampsAvailable(ArrayList<Lamp> lamps);
    public void onItemClick(View v, int position);
}
