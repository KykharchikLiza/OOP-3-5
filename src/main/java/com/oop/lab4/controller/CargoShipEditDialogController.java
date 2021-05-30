package com.oop.lab4.controller;

import com.oop.lab4.vehicle.Engine;
import com.oop.lab4.vehicle.watercraft.CargoShip;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.oop.lab4.MainApp.mainApp;

public class CargoShipEditDialogController {

    @FXML
    public Label serialIdLabel;
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
    public Spinner<Integer> displacementField;
    @FXML
    public Spinner<Integer> deadweightField;
    @FXML
    public Spinner<Integer> crewField;

    @FXML
    private Label warningLabel;

    private CargoShip cargoShip;
    private Stage dialogStage;

    @FXML
    public void onOkBtn() {
        if (serialIdField.isVisible()) {
            if (serialIdField.getText().trim().equals("")) {
                warningLabel.setVisible(true);
                warningLabel.setText("Введите серийный номер!");
                return;
            }
            cargoShip.setSerialNumber(serialIdField.getText());
        }
        if (brandField.getText().trim().equals("")) {
            warningLabel.setVisible(true);
            warningLabel.setText("Введите модель!");
            return;
        }
        cargoShip.setBrand(brandField.getText().trim());
        cargoShip.setYear(yearField.getValue());
        Engine engine = new Engine();
        engine.setEngineCapacity(capacityField.getValue());
        engine.setEnginePower(powerField.getValue());
        cargoShip.setEngine(engine);
        cargoShip.setDisplacement(displacementField.getValue());
        cargoShip.setDeadweight(deadweightField.getValue());
        cargoShip.setCrew(crewField.getValue());

        mainApp.getVehicleList().getVehicles().remove(cargoShip);
        mainApp.getVehicleList().getVehicles().add(cargoShip);

        dialogStage.close();

        mainApp.showVehicles();
    }

    @FXML
    public void onCancelBtn() {
        dialogStage.close();
    }

    public void init(CargoShip cargoShip, Stage dialogStage) {
        this.cargoShip = cargoShip;
        this.dialogStage = dialogStage;
        showDetails();
    }

    private void showDetails() {
        if (cargoShip != null) {
            serialIdLabel.setVisible(true);
            serialIdLabel.setText(cargoShip.getSerialNumber());
            serialIdField.setVisible(false);
            brandField.setText(cargoShip.getBrand());
            yearField.getValueFactory().setValue(cargoShip.getYear());
            powerField.getValueFactory().setValue(cargoShip.getEngine().getEnginePower());
            capacityField.getValueFactory().setValue(cargoShip.getEngine().getEngineCapacity());
            displacementField.getValueFactory().setValue(cargoShip.getDisplacement());
            deadweightField.getValueFactory().setValue(cargoShip.getDeadweight());
            crewField.getValueFactory().setValue(cargoShip.getCrew());
        } else {
            cargoShip = new CargoShip();
            serialIdLabel.setVisible(false);
            serialIdField.setVisible(true);
            serialIdField.setText("");
            brandField.setText("");
            yearField.getValueFactory().setValue(2021);
            powerField.getValueFactory().setValue(0);
            capacityField.getValueFactory().setValue(0);
            displacementField.getValueFactory().setValue(0);
            deadweightField.getValueFactory().setValue(0);
            crewField.getValueFactory().setValue(0);
        }
    }
}