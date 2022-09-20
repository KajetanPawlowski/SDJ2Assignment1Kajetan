package com.example.sdj2assignment1;

import javafx.application.Platform;

public class Thermometer implements Runnable, Observer {
    private double lastTemp = 10;
    private int distance;
    private int sec;
    private int radiatorPower;
    private SummerHouseModel houseModel;

    public Thermometer(SummerHouseModel houseModel, int distance, int sec){
        this.distance = distance;
        this.sec = sec;
        this.houseModel = houseModel;
        radiatorPower = this.houseModel.getRadiatorPower();
    }

    @Override
    public void run() {
        while(true){
            if(distance > 7){//external thermometer
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        lastTemp = externalTemperature(lastTemp, 0,35);
                        houseModel.setOutTemp(lastTemp);
                    }
                });

            }else{// indoor thermometer
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        lastTemp = temperature(lastTemp, houseModel.getRadiatorPower(), distance, houseModel.getOutsideTemp(), sec);
                    }
                });

                if(distance==1){ //distance form the radiator
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            houseModel.setHeaterTemp(lastTemp);
                        }
                    });
                    System.out.println("Heater " + houseModel.getHeaterTemp());
                }else{
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            houseModel.setAmbTemp(lastTemp);
                        }
                    });
                    System.out.println("Amb " + houseModel.getAmbTemp());
                    System.out.println("Out " + houseModel.getOutsideTemp());
                }

            }
            try {
                Thread.sleep(sec * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public double getLastTemp(){
        return lastTemp;
    }

    private double temperature(double lastTemp, int radiatorPower, int distance, double tempOutdoor, int sec) {
        double tMax = Math.min(11 * radiatorPower + 10, 11 * radiatorPower + 10 + tempOutdoor);
        tMax = Math.max(Math.max(lastTemp, tMax), tempOutdoor);

        double heaterTerm = 0;
        if (radiatorPower > 0) {
            double den = Math.max((tMax * (20 - 5 * radiatorPower) * (distance + 5)), 0.1);
            heaterTerm = 30 * sec * Math.abs(tMax - lastTemp) / den;
        }
        double outdoorTerm = (lastTemp - tempOutdoor) * sec / 250.0;
        lastTemp = Math.min(Math.max(lastTemp - outdoorTerm + heaterTerm, tempOutdoor), tMax);
        return lastTemp;
    }

    public double externalTemperature(double lastTemp, double min, double max){
        double left = lastTemp -min;
        double right = max -lastTemp;

        int sign = Math.random() * (left + right) > left ? 1 : -1;
        lastTemp += sign * Math.random();
        return lastTemp;
    }


    @Override
    public void update() {
        radiatorPower = houseModel.getRadiatorPower();
    }
}
