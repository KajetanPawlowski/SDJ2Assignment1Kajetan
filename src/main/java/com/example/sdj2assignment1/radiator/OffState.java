package com.example.sdj2assignment1.radiator;

public class OffState implements RadiatorState {
    private final int POWER = 0;

    public void turnUp(Radiator radiator) {
        radiator.setPowerState(new Power1State());
    }

    public void turnDown(Radiator radiator) {
//	nothing
    }

    public int getPower() {
        return POWER;
    }

}