package com.example.sdj2assignment1.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RadiatorPaneView {
    @FXML
    private Label currentPower;

    private RadiatorPaneViewModel viewModel;

    public RadiatorPaneView(){}

    public void init(RadiatorPaneViewModel viewModel){
        this.viewModel = viewModel;
        currentPower.textProperty().bindBidirectional(this.viewModel.updatePowerLabel());
    }

    @FXML
    protected void onUpButtonClick() {
        viewModel.upCommand();
    }
    @FXML
    protected void onDownButtonClick() {
        viewModel.downCommand();
    }
}