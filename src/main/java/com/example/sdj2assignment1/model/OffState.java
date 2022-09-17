package com.example.sdj2assignment1.model;

public class OffState implements RadiatorState
{
    private static int  POWER = 0;
    //OffState
    //•	The power is a private static final int, set to 0
    //•	Turning down doesn't do anything
    //•	Turning up changes to state 1
    //•	Use getPower to return the power

    public void turnUp(Radiator radiator){
        radiator.setPowerState(new Power1State());
        System.out.println("I am adding up");
    };
    public void turnDown(Radiator radiator){
        System.out.println("I am adding down");

    };
    public int getPower() {
        return POWER;
    };

}
