package com.example.sdj2assignment1.radiator;


import com.example.sdj2assignment1.Observer;
import com.example.sdj2assignment1.Subject;
import javafx.application.Platform;

import java.util.ArrayList;

public class Power3State implements RadiatorState{

    private final int POWER = 3;
    private final int MAX_SEC = 5;
    private final long MILIS = 1000;
    private Thread timer;


    public Power3State(Radiator radiator) {
       timer = new Thread(new Timer(MAX_SEC, radiator));
       timer.start();
    }



    public void turnUp(Radiator radiator) {
//		nothing

    }

    public void turnDown(Radiator radiator) {
        if(timer.isAlive()) {
            timer.stop();
        }
        radiator.setPowerState(new Power2State());


    }

    public int getPower() {
        return POWER;
    }


}