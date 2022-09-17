package com.example.sdj2assignment1.model;

public class Radiator {
    RadiatorState currentState = new OffState();
    Radiator radiator;
    public void turnUp() {
        currentState.turnUp(this);
    }

    public void turnDown(){
        currentState.turnDown(this);
    }
    public void getPower(){

    }
    public void setPowerState(RadiatorState state) {

        this.currentState = state;
    }

    }


