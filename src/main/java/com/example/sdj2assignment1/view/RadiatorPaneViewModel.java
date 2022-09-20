package com.example.sdj2assignment1.view;

import com.example.sdj2assignment1.Observer;
import com.example.sdj2assignment1.SummerHouseModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RadiatorPaneViewModel implements Observer {

    private SummerHouseModel model;
    private StringProperty currentPower;

    public RadiatorPaneViewModel(SummerHouseModel model) {
        this.model = model;
        this.model.attachObserver(this);
        currentPower = new SimpleStringProperty("" + model.getRadiatorPower());
    }

    public void upCommand() {
        model.turnRadiatorUp();
        currentPower.setValue("" + model.getRadiatorPower());
    }

    public void downCommand() {
        model.turnRadiatorDown();
        currentPower.setValue("" + model.getRadiatorPower());
    }

    public StringProperty updatePowerLabel() {
        return currentPower;
    }

    @Override
    public void update() {
        currentPower.setValue("" + model.getRadiatorPower());
    }
}
