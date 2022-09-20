package com.example.sdj2assignment1;

import com.example.sdj2assignment1.view.RadiatorPaneView;
import com.example.sdj2assignment1.view.RadiatorPaneViewModel;
import com.example.sdj2assignment1.view.TempPaneView;
import com.example.sdj2assignment1.view.TempPaneViewModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SimulateHouse extends Application {

    private SummerHouseModel houseModel = new SummerHouseModel();
    private RadiatorPaneViewModel radiatorPaneViewModel= new RadiatorPaneViewModel(houseModel);
    private RadiatorPaneView radiatorPaneView;

    private TempPaneViewModel tempPaneViewModel = new TempPaneViewModel(houseModel);
    private TempPaneView tempPaneView;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Radiator Pane");
        houseModel.attachObserver(radiatorPaneViewModel);
        houseModel.attachObserver(tempPaneViewModel);

        try{
            createRadiatorView();
            createTempView();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    private void createRadiatorView()
            throws Exception
    {
        Stage stage = new Stage();
        stage.setTitle("Radiator Control");
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation( getClass().getResource( "RadiatorPane.fxml" ) );
        Parent root = loader.load();
        stage.setScene(new Scene(root, 320, 240));

        RadiatorPaneView rvc = loader.getController();
        rvc.init(radiatorPaneViewModel);

        stage.show();
    }

    private void createTempView()
            throws Exception
    {
        Stage stage = new Stage();
        stage.setTitle("Temperatures");
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation( getClass().getResource( "TempPane.fxml" ) );
        Parent root = loader.load();
        stage.setScene(new Scene(root, 320, 240));

        TempPaneView tvc = loader.getController();
        tvc.init(tempPaneViewModel);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}