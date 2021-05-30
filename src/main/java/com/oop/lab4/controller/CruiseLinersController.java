package com.oop.lab4.controller;

import com.oop.lab4.MainApp;
import com.oop.lab4.serialization.VehicleList;
import com.oop.lab4.vehicle.watercraft.CruiseLiner;
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

public class CruiseLinersController implements VehiclesController {

    @FXML
    public TableView<CruiseLiner> table;
    @FXML
    public TableColumn<CruiseLiner, String> serialNumberCol;
    @FXML
    public TableColumn<CruiseLiner, String> brandCol;
    @FXML
    public TableColumn<CruiseLiner, String> yearCol;
    @FXML
    public TableColumn<CruiseLiner, String> powerCol;
    @FXML
    public TableColumn<CruiseLiner, String> maxPassengersCol;
    @FXML
    public TableColumn<CruiseLiner, String> displacementCol;
    @FXML
    public TableColumn<CruiseLiner, String> crewCol;
    @FXML
    public TableColumn<CruiseLiner, String> decksCol;

    private final ObservableList<CruiseLiner> items = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        serialNumberCol.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        displacementCol.setCellValueFactory(new PropertyValueFactory<>("displacement"));
        maxPassengersCol.setCellValueFactory(new PropertyValueFactory<>("maxPassengers"));
        crewCol.setCellValueFactory(new PropertyValueFactory<>("crew"));
        decksCol.setCellValueFactory(new PropertyValueFactory<>("decks"));
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
        CruiseLiner item = table.getSelectionModel().getSelectedItem();
        showEditDialog(item);
    }

    @Override
    public void delete() {
        CruiseLiner item = table.getSelectionModel().getSelectedItem();
        mainApp.getVehicleList().getVehicles().remove(item);
        items.remove(item);
    }

    @Override
    public void showVehicles(VehicleList vehicleList) {
        items.clear();
        if (vehicleList != null) {
            List<CruiseLiner> list = vehicleList.castVehicles(CruiseLiner.class);
            items.addAll(list);
        }
    }

    public void showEditDialog(CruiseLiner item) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/CruiseLinerEditDialogLayout.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle((item != null) ? "Редактировать круизный лайнер" : "Добавить круизный лайнер");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            CruiseLinerEditDialogController controller = loader.getController();
            controller.init(item, dialogStage);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
