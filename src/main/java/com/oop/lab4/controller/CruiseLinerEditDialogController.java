package com.oop.lab4.controller;

import com.oop.lab4.vehicle.Engine;
import com.oop.lab4.vehicle.watercraft.CruiseLiner;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.oop.lab4.MainApp.mainApp;

public class CruiseLinerEditDialogController {

    @FXML
    private Label serialIdLabel;
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
    private Spinner<Integer> maxPassengersField;
    @FXML
    private Spinner<Integer> displacementField;
    @FXML
    private Spinner<Integer> crewField;
    @FXML
    private Spinner<Integer> decksField;
    @FXML
    private Label warningLabel;

    private CruiseLiner cruiseLiner;
    private Stage dialogStage;

    @FXML
    public void onOkBtn() {
        if (serialIdField.isVisible()) {
            if (serialIdField.getText().trim().equals("")) {
                warningLabel.setVisible(true);
                warningLabel.setText("Введите серийный номер!");
                return;
            }
            cruiseLiner.setSerialNumber(serialIdField.getText());
        }
        if (brandField.getText().trim().equals("")) {
            warningLabel.setVisible(true);
            warningLabel.setText("Введите модель!");
            return;
        }
        cruiseLiner.setBrand(brandField.getText().trim());
        cruiseLiner.setYear(yearField.getValue());
        Engine engine = new Engine();
        engine.setEngineCapacity(capacityField.getValue());
        engine.setEnginePower(powerField.getValue());
        cruiseLiner.setEngine(engine);
        cruiseLiner.setMaxPassengers(maxPassengersField.getValue());
        cruiseLiner.setDisplacement(displacementField.getValue());
        cruiseLiner.setCrew(crewField.getValue());
        cruiseLiner.setDecks(decksField.getValue());

        mainApp.getVehicleList().getVehicles().remove(cruiseLiner);
        mainApp.getVehicleList().getVehicles().add(cruiseLiner);

        dialogStage.close();

        mainApp.showVehicles();
    }

    @FXML
    public void onCancelBtn() {
        dialogStage.close();
    }

    public void init(CruiseLiner cruiseLiner, Stage dialogStage) {
        this.cruiseLiner = cruiseLiner;
        this.dialogStage = dialogStage;
        showDetails();
    }

    private void showDetails() {
        if (cruiseLiner != null) {
            serialIdLabel.setVisible(true);
            serialIdLabel.setText(cruiseLiner.getSerialNumber());
            serialIdField.setVisible(false);
            brandField.setText(cruiseLiner.getBrand());
            yearField.getValueFactory().setValue(cruiseLiner.getYear());
            powerField.getValueFactory().setValue(cruiseLiner.getEngine().getEnginePower());
            capacityField.getValueFactory().setValue(cruiseLiner.getEngine().getEngineCapacity());
            maxPassengersField.getValueFactory().setValue(cruiseLiner.getMaxPassengers());
            displacementField.getValueFactory().setValue(cruiseLiner.getDisplacement());
            crewField.getValueFactory().setValue(cruiseLiner.getCrew());
            decksField.getValueFactory().setValue(cruiseLiner.getDecks());
        } else {
            cruiseLiner = new CruiseLiner();
            serialIdLabel.setVisible(false);
            serialIdField.setVisible(true);
            serialIdField.setText("");
            brandField.setText("");
            yearField.getValueFactory().setValue(2021);
            powerField.getValueFactory().setValue(0);
            capacityField.getValueFactory().setValue(0);
            maxPassengersField.getValueFactory().setValue(0);
            displacementField.getValueFactory().setValue(0);
            crewField.getValueFactory().setValue(0);
            decksField.getValueFactory().setValue(0);
        }
    }
}