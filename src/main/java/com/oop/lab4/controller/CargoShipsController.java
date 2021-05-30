package com.oop.lab4.controller;

import com.oop.lab4.MainApp;
import com.oop.lab4.serialization.VehicleList;
import com.oop.lab4.vehicle.watercraft.CargoShip;
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

public class CargoShipsController implements VehiclesController {

    @FXML
    public TableView<CargoShip> table;
    @FXML
    public TableColumn<CargoShip, String> serialNumberCol;
    @FXML
    public TableColumn<CargoShip, String> brandCol;
    @FXML
    public TableColumn<CargoShip, String> yearCol;
    @FXML
    public TableColumn<CargoShip, String> displacementCol;
    @FXML
    public TableColumn<CargoShip, String> powerCol;
    @FXML
    public TableColumn<CargoShip, String> deadweightCol;

    private final ObservableList<CargoShip> items = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        serialNumberCol.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        displacementCol.setCellValueFactory(new PropertyValueFactory<>("displacement"));
        deadweightCol.setCellValueFactory(new PropertyValueFactory<>("deadweight"));
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
        CargoShip item = table.getSelectionModel().getSelectedItem();
        showEditDialog(item);
    }

    @Override
    public void delete() {
        CargoShip item = table.getSelectionModel().getSelectedItem();
        mainApp.getVehicleList().getVehicles().remove(item);
        items.remove(item);
    }

    @Override
    public void showVehicles(VehicleList vehicleList) {
        items.clear();
        if (vehicleList != null) {
            List<CargoShip> list = vehicleList.castVehicles(CargoShip.class);
            items.addAll(list);
        }
    }

    private void showEditDialog(CargoShip item) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/CargoShipEditDialogLayout.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle((item != null) ? "Редактировать грузовой корабль" : "Добавить грузовой корабль");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            CargoShipEditDialogController controller = loader.getController();
            controller.init(item, dialogStage);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
