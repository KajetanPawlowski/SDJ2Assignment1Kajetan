package com.example.sdj2assignment1.radiator;

import javax.security.auth.Subject;

public class Radiator {

    private RadiatorState currentState = new OffState();

    public synchronized void turnUp() {
        currentState.turnUp(this);
        System.out.println("Current settings: " +currentState.getPower());
        notify();
    }

    public synchronized void turnDown() {
        currentState.turnDown(this);
        System.out.println("Current settings: " +currentState.getPower());
        notify();
    }

    public int getPower() {
        return currentState.getPower();
    }

    public void setPowerState(RadiatorState state) {
        currentState = state;
    }

}

