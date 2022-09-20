package com.example.sdj2assignment1.radiator;

import com.example.sdj2assignment1.Observer;
import com.example.sdj2assignment1.Subject;
import com.example.sdj2assignment1.SummerHouseModel;
import com.example.sdj2assignment1.view.RadiatorPaneViewModel;

import java.util.ArrayList;

public class Radiator implements Subject{

    private RadiatorState currentState = new OffState();

    public Radiator(SummerHouseModel houseModel){
        attachObserver(houseModel);
    }

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

    public void overheated(){
        notifyObservers();
    }

    public void setPowerState(RadiatorState state) {
        currentState = state;
    }

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    @Override
    public synchronized void attachObserver( Observer observer )
    {
        observers.add( observer );
    }
    @Override
    public synchronized void detachObserver( Observer observer)
    {
        observers.remove( observer );
    }
    @Override
    public void notifyObservers()
    {
        for( Observer o: observers )
            o.update();
    }
}

