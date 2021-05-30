package com.oop.lab4.controller;

import com.oop.lab4.MainApp;
import com.oop.lab4.serialization.VehicleList;
import com.oop.lab4.vehicle.landcraft.Bus;
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

public class BusesController implements VehiclesController {

    @FXML
    public TableView<Bus> table;
    @FXML
    public TableColumn<Bus, String> serialNumberCol;
    @FXML
    public TableColumn<Bus, String> brandCol;
    @FXML
    public TableColumn<Bus, String> yearCol;
    @FXML
    public TableColumn<Bus, String> colorCol;
    @FXML
    public TableColumn<Bus, String> powerCol;
    @FXML
    public TableColumn<Bus, String> maxPassengersCol;
    @FXML
    public TableColumn<Bus, String> doorsCol;

    private final ObservableList<Bus> items = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        serialNumberCol.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        maxPassengersCol.setCellValueFactory(new PropertyValueFactory<>("maxPassengers"));
        doorsCol.setCellValueFactory(new PropertyValueFactory<>("doors"));
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
        Bus item = table.getSelectionModel().getSelectedItem();
        showEditDialog(item);
    }

    @Override
    public void delete() {
        Bus item = table.getSelectionModel().getSelectedItem();
        mainApp.getVehicleList().getVehicles().remove(item);
        items.remove(item);
    }

    @Override
    public void showVehicles(VehicleList vehicleList) {
        items.clear();
        if (vehicleList != null) {
            List<Bus> list = vehicleList.castVehicles(Bus.class);
            items.addAll(list);
        }
    }

    private void showEditDialog(Bus item) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/BusEditDialogLayout.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle((item != null) ? "Редактировать автобус" : "Добавить автобус");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            BusEditDialogController controller = loader.getController();
            controller.init(item, dialogStage);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
