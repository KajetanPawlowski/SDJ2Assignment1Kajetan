package com.example.sdj2assignment1.model;

public class Power1State implements RadiatorState
{
    private static int POWER = 1;

   //Power1State
    //•	Power is 1
    //•	Up or down switches the state to Power2State or OffState

    public void turnUp(Radiator radiator){
        radiator.setPowerState(new Power2State());
        System.out.println("I am adding up, switching to 2");
    };
    public void turnDown(Radiator radiator){
        radiator.setPowerState(new OffState());
        System.out.println("OFF");
    };
    public int getPower() {
        return POWER;
    };
}
