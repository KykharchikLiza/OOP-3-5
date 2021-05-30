package com.oop.lab4.controller;

import com.oop.lab4.vehicle.watercraft.SailBoat;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.oop.lab4.MainApp.mainApp;

public class SailBoatEditDialogController {

    @FXML
    public Label serialIdLabel;
    @FXML
    private TextField serialIdField;
    @FXML
    private TextField brandField;
    @FXML
    private Spinner<Integer> yearField;
    @FXML
    public Spinner<Integer> displacementField;
    @FXML
    public Spinner<Integer> mastsField;
    @FXML
    public Spinner<Integer> crewField;
    @FXML
    private Label warningLabel;

    private SailBoat sailBoat;
    private Stage dialogStage;

    @FXML
    public void onOkBtn() {
        if (serialIdField.isVisible()) {
            if (serialIdField.getText().trim().equals("")) {
                warningLabel.setVisible(true);
                warningLabel.setText("Введите серийный номер!");
                return;
            }
            sailBoat.setSerialNumber(serialIdField.getText());
        }
        if (brandField.getText().trim().equals("")) {
            warningLabel.setVisible(true);
            warningLabel.setText("Введите модель!");
            return;
        }
        sailBoat.setBrand(brandField.getText().trim());
        sailBoat.setYear(yearField.getValue());
        sailBoat.setDisplacement(displacementField.getValue());
        sailBoat.setMasts(mastsField.getValue());
        sailBoat.setCrew(crewField.getValue());

        mainApp.getVehicleList().getVehicles().remove(sailBoat);
        mainApp.getVehicleList().getVehicles().add(sailBoat);

        dialogStage.close();

        mainApp.showVehicles();
    }

    @FXML
    public void onCancelBtn() {
        dialogStage.close();
    }

    public void init(SailBoat sailBoats, Stage dialogStage) {
        this.sailBoat = sailBoats;
        this.dialogStage = dialogStage;
        showDetails();
    }

    private void showDetails() {
        if (sailBoat != null) {
            serialIdLabel.setVisible(true);
            serialIdLabel.setText(sailBoat.getSerialNumber());
            serialIdField.setVisible(false);
            brandField.setText(sailBoat.getBrand());
            yearField.getValueFactory().setValue(sailBoat.getYear());
            displacementField.getValueFactory().setValue(sailBoat.getDisplacement());
            mastsField.getValueFactory().setValue(sailBoat.getMasts());
            crewField.getValueFactory().setValue(sailBoat.getCrew());
        } else {
            sailBoat = new SailBoat();
            serialIdLabel.setVisible(false);
            serialIdField.setVisible(true);
            serialIdField.setText("");
            brandField.setText("");
            yearField.getValueFactory().setValue(2021);
            displacementField.getValueFactory().setValue(0);
            mastsField.getValueFactory().setValue(0);
            crewField.getValueFactory().setValue(0);
        }
    }
}