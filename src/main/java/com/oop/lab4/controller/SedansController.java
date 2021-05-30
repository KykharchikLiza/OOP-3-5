package com.oop.lab4.controller;

import com.oop.lab4.MainApp;
import com.oop.lab4.serialization.VehicleList;
import com.oop.lab4.vehicle.landcraft.Sedan;
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

public class SedansController implements VehiclesController {

    @FXML
    private TableView<Sedan> table;
    @FXML
    private TableColumn<Sedan, String> serialNumberCol;
    @FXML
    private TableColumn<Sedan, String> brandCol;
    @FXML
    private TableColumn<Sedan, String> yearCol;
    @FXML
    private TableColumn<Sedan, String> colorCol;
    @FXML
    private TableColumn<Sedan, String> carBodyTypeCol;
    @FXML
    private TableColumn<Sedan, String> powerCol;
    @FXML
    private TableColumn<Sedan, String> doorsCol;

    private final ObservableList<Sedan> items = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        serialNumberCol.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        carBodyTypeCol.setCellValueFactory(new PropertyValueFactory<>("carBodyType"));
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
        Sedan item = table.getSelectionModel().getSelectedItem();
        showEditDialog(item);
    }

    @Override
    public void delete() {
        Sedan item = table.getSelectionModel().getSelectedItem();
        mainApp.getVehicleList().getVehicles().remove(item);
        items.remove(item);
    }

    @Override
    public void showVehicles(VehicleList vehicleList) {
        items.clear();
        if (vehicleList != null) {
            List<Sedan> list = vehicleList.castVehicles(Sedan.class);
            items.addAll(list);
        }
    }

    public void showEditDialog(Sedan item) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/SedanEditDialogLayout.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle((item != null) ? "Редактировать легковой автомобиль" : "Добавить легковой автомобиль");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            SedanEditDialogController controller = loader.getController();
            controller.init(item, dialogStage);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
