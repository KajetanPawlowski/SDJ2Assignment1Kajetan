package com.example.sdj2assignment1.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TempPaneView {
    private TempPaneViewModel viewModel;
    @FXML
    private Label tempAmbLabel;

    @FXML
    private Label tempHeaterLabel;

    @FXML
    private Label tempOutLabel;

    public TempPaneView(){}

    public void init(TempPaneViewModel viewModel){
        this.viewModel = viewModel;
        tempAmbLabel.textProperty().bindBidirectional(this.viewModel.getTempAmb());
        tempHeaterLabel.textProperty().bindBidirectional(this.viewModel.getTempH());
        tempOutLabel.textProperty().bindBidirectional(this.viewModel.getTempOut());
    }

}
