package com.oop.lab4.controller;

import com.oop.lab4.MainApp;
import com.oop.lab4.serialization.VehicleList;
import com.oop.lab4.vehicle.landcraft.Truck;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static com.oop.lab4.MainApp.mainApp;

public class TrucksController implements VehiclesController {

    @FXML
    public TableView<Truck> table;
    @FXML
    public TableColumn<Truck, String> serialNumberCol;
    @FXML
    public TableColumn<Truck, String> brandCol;
    @FXML
    public TableColumn<Truck, String> yearCol;
    @FXML
    public TableColumn<Truck, String> axisCountCol;
    @FXML
    public TableColumn<Truck, String> maxCargoWeightCol;
    @FXML
    public TableColumn<Truck, String> powerCol;

    private final ObservableList<Truck> items = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        serialNumberCol.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        axisCountCol.setCellValueFactory(new PropertyValueFactory<>("axisCount"));
        maxCargoWeightCol.setCellValueFactory(new PropertyValueFactory<>("maxCargoWeight"));
        powerCol.setCellValueFactory(c ->
                new SimpleStringProperty(String.valueOf(c.getValue().getEngine().getEnginePower())));

        table.setItems(items);
    }

    @Override
    public void add() {
        showEditDialog(null);
    }

    @Override
    public void edit() {
        Truck item = table.getSelectionModel().getSelectedItem();
        showEditDialog(item);
    }

    @Override
    public void delete() {
        Truck item = table.getSelectionModel().getSelectedItem();
        mainApp.getVehicleList().getVehicles().remove(item);
        items.remove(item);
    }

    @Override
    public void showVehicles(VehicleList vehicleList) {
        items.clear();
        if (vehicleList != null) {
            List<Truck> list = vehicleList.castVehicles(Truck.class);
            items.addAll(list);
        }
    }

    public void showEditDialog(Truck item) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/TruckEditDialogLayout.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle((item != null) ? "Редактировать грузовик" : "Добавить грузовик");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            TruckEditDialogController controller = loader.getController();
            controller.init(item, dialogStage);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
