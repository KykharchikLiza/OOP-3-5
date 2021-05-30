package com.oop.lab4.controller;

import com.oop.lab4.vehicle.Engine;
import com.oop.lab4.vehicle.landcraft.Truck;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.oop.lab4.MainApp.mainApp;

public class TruckEditDialogController {

    @FXML
    public Label serialIdLabel;
    @FXML
    private TextField colorField;
    @FXML
    private TextField serialIdField;
    @FXML
    private TextField brandField;
    @FXML
    private Spinner<Integer> yearField;
    @FXML
    private Spinner<Integer> axisField;
    @FXML
    private Spinner<Integer> maxCargoField;
    @FXML
    private Spinner<Integer> powerField;
    @FXML
    private Spinner<Integer> capacityField;
    @FXML
    private Label warningLabel;

    private Truck truck;
    private Stage dialogStage;

    @FXML
    public void onOkBtn() {
        if (serialIdField.isVisible()) {
            if (serialIdField.getText().trim().equals("")) {
                warningLabel.setVisible(true);
                warningLabel.setText("Введите серийный номер!");
                return;
            }
            truck.setSerialNumber(serialIdField.getText());
        }
        if (brandField.getText().trim().equals("")) {
            warningLabel.setVisible(true);
            warningLabel.setText("Введите модель!");
            return;
        }
        truck.setColor(colorField.getText().trim());
        truck.setBrand(brandField.getText().trim());
        truck.setYear(yearField.getValue());
        truck.setAxisCount(axisField.getValue());
        truck.setMaxCargoWeight(maxCargoField.getValue());
        Engine engine = new Engine();
        engine.setEngineCapacity(capacityField.getValue());
        engine.setEnginePower(powerField.getValue());
        truck.setEngine(engine);

        mainApp.getVehicleList().getVehicles().remove(truck);
        mainApp.getVehicleList().getVehicles().add(truck);

        dialogStage.close();

        mainApp.showVehicles();
    }

    @FXML
    public void onCancelBtn() {
        dialogStage.close();
    }

    public void init(Truck truck, Stage dialogStage) {
        this.truck = truck;
        this.dialogStage = dialogStage;
        showDetails();
    }

    private void showDetails() {
        if (truck != null) {
            serialIdLabel.setVisible(true);
            serialIdLabel.setText(truck.getSerialNumber());
            serialIdField.setVisible(false);
            colorField.setText(truck.getColor());
            brandField.setText(truck.getBrand());
            yearField.getValueFactory().setValue(truck.getYear());
            axisField.getValueFactory().setValue(truck.getAxisCount());
            maxCargoField.getValueFactory().setValue(truck.getMaxCargoWeight());
            powerField.getValueFactory().setValue(truck.getEngine().getEnginePower());
            capacityField.getValueFactory().setValue(truck.getEngine().getEngineCapacity());
        } else {
            truck = new Truck();
            serialIdLabel.setVisible(false);
            serialIdField.setVisible(true);
            serialIdField.setText("");
            colorField.setText("");
            brandField.setText("");
            yearField.getValueFactory().setValue(2021);
            axisField.getValueFactory().setValue(2);
            maxCargoField.getValueFactory().setValue(0);
            powerField.getValueFactory().setValue(0);
            capacityField.getValueFactory().setValue(0);
        }
    }
}