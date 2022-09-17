package com.example.sdj2assignment1.model;

public class Power2State implements RadiatorState
{
    private static int POWER = 2;
    //Power2State
    //•	Power is 2
    //•	Up or down switches the state to Power3State or Power2State
    //So Power1State and Power2State are very similar.
    public void turnUp(Radiator radiator){
        radiator.setPowerState(new Power3State(radiator));
        System.out.println("I am adding up to State 3");
    };
    public void turnDown(Radiator radiator){
        radiator.setPowerState(new Power1State());
        System.out.println("I am adding down to 1");
    };
    public int getPower() {
        return POWER;
    };
}
