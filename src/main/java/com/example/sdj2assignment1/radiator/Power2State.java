package com.example.sdj2assignment1.radiator;

public class Power2State implements RadiatorState{

    private final int POWER = 2;

    public void turnUp(Radiator radiator) {
        radiator.setPowerState(new Power3State(radiator));

    }

    public void turnDown(Radiator radiator) {
        radiator.setPowerState(new Power1State());

    }

    public int getPower() {
        return POWER;
    }


}