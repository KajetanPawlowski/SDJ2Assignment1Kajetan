package com.example.sdj2assignment1.radiator;


public class Power3State implements RadiatorState{

    private final int POWER = 3;
    private final int MAX_SEC = 5;
    private final long MILIS = 1000;
    private Thread timer;


    public Power3State(Radiator radiator) {
        timer = new Thread(new Timer(MAX_SEC, radiator));
        timer.start();
    }

    private class Timer implements Runnable{
        private long timeInSec;
        private Radiator radiator;

        public Timer(int timeInSec, Radiator radiator) {
            this.timeInSec = timeInSec;
            this.radiator = radiator;

        }

        public void run() {
            try {
                Thread.sleep(timeInSec * MILIS);
                System.out.println("OVERHEATED! Power: 2");
                radiator.setPowerState(new Power2State());;

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

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