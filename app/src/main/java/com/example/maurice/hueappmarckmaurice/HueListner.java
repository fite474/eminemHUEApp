package com.example.maurice.hueappmarckmaurice;

import java.util.ArrayList;

public interface HueListner {
    public void onLampAvailable(Lamp lamp);
    public void onLampWallError(String errorString);
    void onUserNameAvailable(String userName);
    void onAllLampsAvailable(ArrayList<Lamp> lamps);
}
