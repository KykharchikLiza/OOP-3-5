package com.oop.lab4.controller;

import com.oop.lab4.vehicle.Engine;
import com.oop.lab4.vehicle.landcraft.Sedan;
import com.oop.lab4.vehicle.landcraft.Sedan.CarBodyType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.oop.lab4.MainApp.mainApp;

public class SedanEditDialogController {

    @FXML
    private Label serialIdLabel;
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
    private Spinner<Integer> doorsField;
    @FXML
    private ChoiceBox<CarBodyType> bodyField;
    @FXML
    private Label warningLabel;

    private Sedan sedan;
    private Stage dialogStage;

    @FXML
    public void onOkBtn() {
        if (serialIdField.isVisible()) {
            if (serialIdField.getText().trim().equals("")) {
                warningLabel.setVisible(true);
                warningLabel.setText("Введите серийный номер!");
                return;
            }
            sedan.setSerialNumber(serialIdField.getText());
        }
        if (brandField.getText().trim().equals("")) {
            warningLabel.setVisible(true);
            warningLabel.setText("Введите модель!");
            return;
        }
        sedan.setColor(colorField.getText().trim());
        sedan.setBrand(brandField.getText().trim());
        sedan.setYear(yearField.getValue());
        Engine engine = new Engine();
        engine.setEngineCapacity(capacityField.getValue());
        engine.setEnginePower(powerField.getValue());
        sedan.setEngine(engine);
        sedan.setDoors(doorsField.getValue());
        sedan.setCarBodyType(bodyField.getSelectionModel().getSelectedItem());

        mainApp.getVehicleList().getVehicles().remove(sedan);
        mainApp.getVehicleList().getVehicles().add(sedan);

        dialogStage.close();

        mainApp.showVehicles();
    }

    @FXML
    public void onCancelBtn() {
        dialogStage.close();
    }

    public void init(Sedan sedan, Stage dialogStage) {
        this.sedan = sedan;
        this.dialogStage = dialogStage;

        ObservableList<CarBodyType> bodyTypes = FXCollections.observableArrayList(CarBodyType.values());
        bodyField.setItems(bodyTypes);

        showDetails();
    }

    private void showDetails() {
        if (sedan != null) {
            serialIdLabel.setVisible(true);
            serialIdLabel.setText(sedan.getSerialNumber());
            serialIdField.setVisible(false);
            colorField.setText(sedan.getColor());
            brandField.setText(sedan.getBrand());
            yearField.getValueFactory().setValue(sedan.getYear());
            powerField.getValueFactory().setValue(sedan.getEngine().getEnginePower());
            capacityField.getValueFactory().setValue(sedan.getEngine().getEngineCapacity());
            doorsField.getValueFactory().setValue(sedan.getDoors());
            bodyField.getSelectionModel().select(sedan.getCarBodyType());
        } else {
            sedan = new Sedan();
            serialIdLabel.setVisible(false);
            serialIdField.setVisible(true);
            serialIdField.setText("");
            colorField.setText("");
            brandField.setText("");
            yearField.getValueFactory().setValue(2021);
            powerField.getValueFactory().setValue(0);
            capacityField.getValueFactory().setValue(0);
            doorsField.getValueFactory().setValue(0);
            bodyField.getSelectionModel().selectFirst();
        }
    }
}