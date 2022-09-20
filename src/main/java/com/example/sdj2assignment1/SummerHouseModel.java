package com.example.sdj2assignment1;

import com.example.sdj2assignment1.radiator.Radiator;
import com.example.sdj2assignment1.view.RadiatorPaneViewModel;
import com.example.sdj2assignment1.view.TempPaneViewModel;
import javafx.application.Platform;

import java.util.ArrayList;

public class SummerHouseModel implements Subject,  Observer{
        private Radiator radiator;

        private TemperatureList tempList;

        public SummerHouseModel(){
            radiator = new Radiator(this);
            tempList = new TemperatureList(this, 20,20,20);
        }
        public Radiator getRadiator(){
            return radiator;
        }

        public synchronized void setHeaterTemp(double nextTemp){
            tempList.setTemp(1,nextTemp);
            notifyObservers();
        }

        public synchronized void setOutTemp(double nextTemp){
            tempList.setTemp(0,nextTemp);
            notifyObservers();
        }

        public synchronized void setAmbTemp(double nextTemp){
            tempList.setTemp(2,nextTemp);
            notifyObservers();
        }

        public synchronized double getOutsideTemp(){
            return tempList.getTemp(0);
        }

        public synchronized double getHeaterTemp(){return tempList.getTemp(1); }

        public synchronized double getAmbTemp(){return tempList.getTemp(2); }


        public void turnRadiatorUp(){ radiator.turnUp(); }

        public void turnRadiatorDown(){ radiator.turnDown(); }

        public synchronized int getRadiatorPower(){
        return radiator.getPower();
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

        @Override
        public void update() {
            notifyObservers();
        }
}
