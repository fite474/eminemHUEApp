package com.example.maurice.hueappmarckmaurice;

public interface HueListner {
    public void onLampAvailable(Lamp lamp);
    public void onLampWallError(String errorString);
}
