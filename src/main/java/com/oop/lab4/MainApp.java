package com.oop.lab4;

import com.oop.lab4.controller.VehiclesController;
import com.oop.lab4.serialization.VehicleList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class MainApp extends Application {

    public static MainApp mainApp;
    private VehicleList vehicleList = new VehicleList();

    private Stage primaryStage;
    private BorderPane rootLayout;
    private VehiclesController vehiclesController;

    @Override
    public void start(Stage primaryStage) {
        mainApp = this;
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Lab3");

        initRootLayout();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/RootLayout.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(fxml));
            AnchorPane TableViewLayout = loader.load();
            rootLayout.setCenter(TableViewLayout);
            vehiclesController = loader.getController();
            showVehicles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showVehicles() {
        if (vehiclesController != null) {
            vehiclesController.showVehicles(vehicleList);
        }
    }

    public Window getPrimaryStage() {
        return primaryStage;
    }

    public VehicleList getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(VehicleList vehicleList) {
        this.vehicleList = vehicleList;
    }

    public VehiclesController getVehiclesController() {
        return vehiclesController;
    }

    public static void main(String[] args) {
        launch(args);
    }
}