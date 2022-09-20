package com.example.sdj2assignment1.radiator;

import javafx.application.Platform;

public class Timer implements Runnable{
    private final int MAX_SEC = 5;
    private final long MILIS = 1000;
    private long timeInSec;
    private Radiator radiator;

    public Timer(int timeInSec, Radiator radiator) {
        this.timeInSec = timeInSec;
        this.radiator = radiator;

    }
    @Override
    public void run() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(MAX_SEC * MILIS);
                    System.out.println("OVERHEATED! Power: 2");
                    radiator.setPowerState(new Power2State());
                    radiator.overheated();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


