package com.oop.lab4.controller;

import com.oop.lab4.MainApp;
import com.oop.lab4.serialization.VehicleList;
import com.oop.lab4.vehicle.watercraft.SailBoat;
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

public class SailBoatsController implements VehiclesController {

    @FXML
    public TableView<SailBoat> table;
    @FXML
    public TableColumn<SailBoat, String> serialNumberCol;
    @FXML
    public TableColumn<SailBoat, String> brandCol;
    @FXML
    public TableColumn<SailBoat, String> yearCol;
    @FXML
    public TableColumn<SailBoat, String> displacementCol;
    @FXML
    public TableColumn<SailBoat, String> mastsCol;
    @FXML
    public TableColumn<SailBoat, String> crewCol;

    private final ObservableList<SailBoat> items = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        serialNumberCol.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        displacementCol.setCellValueFactory(new PropertyValueFactory<>("displacement"));
        mastsCol.setCellValueFactory(new PropertyValueFactory<>("masts"));
        crewCol.setCellValueFactory(new PropertyValueFactory<>("crew"));

        table.setItems(items);
    }

    @Override
    public void add() {
        showEditDialog(null);
    }


    @Override
    public void edit() {
        SailBoat item = table.getSelectionModel().getSelectedItem();
        showEditDialog(item);
    }

    @Override
    public void delete() {
        SailBoat item = table.getSelectionModel().getSelectedItem();
        mainApp.getVehicleList().getVehicles().remove(item);
        items.remove(item);
    }

    @Override
    public void showVehicles(VehicleList vehicleList) {
        items.clear();
        if (vehicleList != null) {
            List<SailBoat> list = vehicleList.castVehicles(SailBoat.class);
            items.addAll(list);
        }
    }

    public void showEditDialog(SailBoat item) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/SailBoatEditDialogLayout.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle((item != null) ? "Редактировать парусный корабль" : "Добавить парусный корабль");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            SailBoatEditDialogController controller = loader.getController();
            controller.init(item, dialogStage);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
