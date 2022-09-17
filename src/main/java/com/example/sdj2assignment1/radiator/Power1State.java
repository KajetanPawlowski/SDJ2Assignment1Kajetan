package com.example.sdj2assignment1.radiator;
public class Power1State implements RadiatorState{

    private final int POWER = 1;

    public void turnUp(Radiator radiator) {
        radiator.setPowerState(new Power2State());

    }

    public void turnDown(Radiator radiator) {
        radiator.setPowerState(new OffState());

    }

    public int getPower() {
        return POWER;
    }


}