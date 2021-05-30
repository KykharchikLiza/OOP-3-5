package com.oop.lab4.controller;

import com.oop.lab4.vehicle.Engine;
import com.oop.lab4.vehicle.landcraft.Bus;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.oop.lab4.MainApp.mainApp;

public class BusEditDialogController {

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
    private Spinner<Integer> powerField;
    @FXML
    private Spinner<Integer> capacityField;
    @FXML
    public Spinner<Integer> maxPassengersField;
    @FXML
    public Spinner<Integer> doorsField;
    @FXML
    public Spinner<Integer> axisField;
    @FXML
    private Label warningLabel;

    private Bus bus;
    private Stage dialogStage;

    @FXML
    public void onOkBtn() {
        if (serialIdField.isVisible()) {
            if (serialIdField.getText().trim().equals("")) {
                warningLabel.setVisible(true);
                warningLabel.setText("Введите серийный номер!");
                return;
            }
            bus.setSerialNumber(serialIdField.getText());
        }
        if (brandField.getText().trim().equals("")) {
            warningLabel.setVisible(true);
            warningLabel.setText("Введите модель!");
            return;
        }
        bus.setColor(colorField.getText().trim());
        bus.setBrand(brandField.getText().trim());
        bus.setYear(yearField.getValue());
        Engine engine = new Engine();
        engine.setEngineCapacity(capacityField.getValue());
        engine.setEnginePower(powerField.getValue());
        bus.setEngine(engine);
        bus.setMaxPassengers(maxPassengersField.getValue());
        bus.setDoors(doorsField.getValue());
        bus.setAxisCount(axisField.getValue());

        mainApp.getVehicleList().getVehicles().remove(bus);
        mainApp.getVehicleList().getVehicles().add(bus);

        dialogStage.close();

        mainApp.showVehicles();
    }

    @FXML
    public void onCancelBtn() {
        dialogStage.close();
    }

    public void init(Bus bus, Stage dialogStage) {
        this.bus = bus;
        this.dialogStage = dialogStage;
        showDetails();
    }

    private void showDetails() {
        if (bus != null) {
            serialIdLabel.setVisible(true);
            serialIdLabel.setText(bus.getSerialNumber());
            serialIdField.setVisible(false);
            colorField.setText(bus.getColor());
            brandField.setText(bus.getBrand());
            yearField.getValueFactory().setValue(bus.getYear());
            powerField.getValueFactory().setValue(bus.getEngine().getEnginePower());
            capacityField.getValueFactory().setValue(bus.getEngine().getEngineCapacity());
            maxPassengersField.getValueFactory().setValue(bus.getMaxPassengers());
            doorsField.getValueFactory().setValue(bus.getDoors());
            axisField.getValueFactory().setValue(bus.getAxisCount());
        } else {
            bus = new Bus();
            serialIdLabel.setVisible(false);
            serialIdField.setVisible(true);
            serialIdField.setText("");
            colorField.setText("");
            brandField.setText("");
            yearField.getValueFactory().setValue(2021);
            powerField.getValueFactory().setValue(0);
            capacityField.getValueFactory().setValue(0);
            maxPassengersField.getValueFactory().setValue(0);
            doorsField.getValueFactory().setValue(1);
            axisField.getValueFactory().setValue(2);
        }
    }
}