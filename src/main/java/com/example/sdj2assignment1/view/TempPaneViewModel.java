package com.example.sdj2assignment1.view;

import com.example.sdj2assignment1.Observer;
import com.example.sdj2assignment1.SummerHouseModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.DecimalFormat;

public class TempPaneViewModel implements Observer {
    private SummerHouseModel houseModel;

    private StringProperty tempH = new SimpleStringProperty();
    private StringProperty tempAmb = new SimpleStringProperty();
    private StringProperty tempOut = new SimpleStringProperty();
    private DecimalFormat df = new DecimalFormat("#0.0");

    public TempPaneViewModel(SummerHouseModel houseModel){
        this.houseModel = houseModel;
        this.houseModel.attachObserver(this);
        tempH.setValue(this.houseModel.getHeaterTemp()+"");
        tempOut.setValue(this.houseModel.getOutsideTemp()+"");
        tempAmb.setValue(this.houseModel.getAmbTemp()+"");
    }

    public StringProperty getTempH(){
        return tempH;
    }

    public StringProperty getTempAmb(){
        return tempAmb;
    }

    public StringProperty getTempOut(){
        return tempOut;
    }

    public void updateTempH(){
        tempH.setValue(df.format(houseModel.getHeaterTemp()));
    }
    public void updateTempAmb(){
        tempAmb.setValue(df.format(houseModel.getAmbTemp()));
    }
    public void updateTempOut(){
        tempOut.setValue(df.format(houseModel.getOutsideTemp()));
    }

    @Override
    public void update() {
        updateTempAmb();
        updateTempOut();
        updateTempH();
    }
}
