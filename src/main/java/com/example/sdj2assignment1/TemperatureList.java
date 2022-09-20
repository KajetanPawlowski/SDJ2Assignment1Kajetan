package com.example.sdj2assignment1;

import com.example.sdj2assignment1.radiator.Radiator;
import com.example.sdj2assignment1.view.RadiatorPaneView;
import com.example.sdj2assignment1.view.RadiatorPaneViewModel;
import javafx.application.Platform;

import java.text.DecimalFormat;

public class TemperatureList {
    private double[] tempList = new double[3];
    //index 0 - outside temp
    //index 1 - Heater temp
    //index 2 - ambient temp
    private SummerHouseModel houseModel;
    private Radiator radiator;

    private Runnable AmbThermometer ;
    private Runnable RadiatorThermometer;
    private Runnable OutsideThermometer;
    private Thread[] temperatures = new Thread[3];


    public TemperatureList(SummerHouseModel model, double out, double heater, double amb){
        houseModel = model;
        AmbThermometer = new Thermometer(houseModel, 7, 6);
        RadiatorThermometer = new Thermometer(houseModel, 1, 6);
        OutsideThermometer = new Thermometer(houseModel, 10, 6);
        tempList[0] = out;
        tempList[1] = heater;
        tempList[2] = amb;
        radiator = model.getRadiator();

        temperatures[0] = new Thread(AmbThermometer);
        temperatures[1] = new Thread(RadiatorThermometer);
        temperatures[2] = new Thread(OutsideThermometer);

        temperatures[0].start();
        temperatures[1].start();
        temperatures[2].start();

    }

    public void setTemp(int index, double nextTemp){
        tempList[index] = nextTemp;
    }
    public double getTemp(int index){
        return tempList[index];
    }

}
