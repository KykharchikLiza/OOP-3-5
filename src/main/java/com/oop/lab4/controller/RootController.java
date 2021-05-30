package com.oop.lab4.controller;

import com.oop.lab4.serialization.Serialization;
import com.oop.lab4.serialization.Transformation;
import com.oop.lab4.serialization.VehicleList;
import com.oop.lab4.vehicle.Movable;
import com.oop.lab4.vehicle.Vehicle;
import com.oop.lab4.vehicle.aircraft.Plane;
import com.oop.lab4.vehicle.command.RunVehicleOperation;
import com.oop.lab4.vehicle.command.StopVehicleOperation;
import com.oop.lab4.vehicle.command.VehicleOperationExecutor;
import com.oop.lab4.vehicle.decorator.FastMoveDecorator;
import com.oop.lab4.vehicle.decorator.SlowMoveDecorator;
import com.oop.lab4.vehicle.landcraft.Sedan;
import com.oop.lab4.vehicle.landcraft.Train;
import com.oop.lab4.vehicle.landcraft.Truck;
import com.oop.lab4.vehicle.watercraft.CruiseLiner;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;


import java.io.File;

import static com.oop.lab4.MainApp.mainApp;

public class RootController {

    private File initialDirectory;

    @FXML
    public BorderPane borderPane;

    @FXML
    public void onShowSedans() {
        mainApp.show("/fxml/SedansLayout.fxml");
    }

    @FXML
    public void onShowTrucks() {
        mainApp.show("/fxml/TrucksLayout.fxml");
    }

    @FXML
    public void onShowBuses() {
        mainApp.show("/fxml/BusesLayout.fxml");
    }

    @FXML
    public void onShowCargoShips() {
        mainApp.show("/fxml/CargoShipsLayout.fxml");
    }

    @FXML
    public void onShowCruiseLiners() {
        mainApp.show("/fxml/CruiseLinersLayout.fxml");
    }

    @FXML
    public void onShowSailBoats() {
        mainApp.show("/fxml/SailBoatsLayout.fxml");
    }

    @FXML
    public void serialize() {
        Serialization.serialize(mainApp.getVehicleList());
    }

    @FXML
    public void serializeXML() {
        Serialization.serializeXML(mainApp.getVehicleList());
    }

    @FXML
    public void serializeJSON() {
        Serialization.serializeJson(mainApp.getVehicleList());
    }

    @FXML
    public void deserialize() {
        Object obj = Serialization.deserialize();
        if (obj instanceof VehicleList) {
            mainApp.setVehicleList((VehicleList) obj);
            mainApp.showVehicles();
        }
    }

    @FXML
    public void deserializeXML() {
        VehicleList vehicleList = Serialization.deserializeXML(VehicleList.class);
        if (vehicleList != null) {
            mainApp.setVehicleList(vehicleList);
            mainApp.showVehicles();
        }
    }

    @FXML
    public void deserializeJSON() {
        VehicleList vehicleList = Serialization.deserializeJson(VehicleList.class);
        if (vehicleList != null) {
            mainApp.setVehicleList(vehicleList);
            mainApp.showVehicles();
        }
    }

    @FXML
    public void onAddMenu() {
        if (mainApp.getVehiclesController() != null) {
            mainApp.getVehiclesController().add();
        }
    }

    @FXML
    public void onEditMenu() {
        if (mainApp.getVehiclesController() != null) {
            mainApp.getVehiclesController().edit();
        }
    }

    @FXML
    public void onDeleteMenu() {
        if (mainApp.getVehiclesController() != null) {
            mainApp.getVehiclesController().delete();
        }
    }

    @FXML
    public void saveAs() {
        FileChooser fileChooser = createFileChooser();
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
        if (file != null) {
            initialDirectory = file.getParentFile();
            String filePath = file.getPath();
            if (filePath.endsWith(".xml")) {
                //Transformation.saveXML(mainApp.getVehicleList(), filePath);
                Transformation.saveTransformXml(mainApp.getVehicleList(), filePath);
            } else if (filePath.endsWith(".json")) {
                Transformation.saveJson(mainApp.getVehicleList(), filePath);
            }
        }
    }

    @FXML
    public void load() {
        FileChooser fileChooser = createFileChooser();
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        if (file != null) {
            initialDirectory = file.getParentFile();
            String filePath = file.getPath();
            VehicleList vehicleList = null;
            if (filePath.endsWith(".xml")) {
                vehicleList = Transformation.loadXml(filePath, VehicleList.class);
            } else if (filePath.endsWith(".json")) {
                vehicleList = Transformation.loadJson(filePath, VehicleList.class);
            }
            if (vehicleList != null) {
                mainApp.setVehicleList(vehicleList);
                mainApp.showVehicles();
            }
        }
    }

    private FileChooser createFileChooser() {
        FileChooser fileChooser = new FileChooser();
        ExtensionFilter xmlFilter = new ExtensionFilter("Xml files (*.xml)", "*.xml");
        ExtensionFilter jsonFilter = new ExtensionFilter("Json files (*.json)", "*.json");
        fileChooser.getExtensionFilters().addAll(xmlFilter, jsonFilter);
        if (initialDirectory != null) {
            fileChooser.setInitialDirectory(initialDirectory);
        }
        return fileChooser;
    }

    @FXML
    public void onAdapter() {
        StringBuilder str = new StringBuilder();

        Vehicle plane = new Plane();
        plane.setSpeed(50);
        str.append(plane.move()).append("\n");

        Vehicle cruiseLiner = new CruiseLiner();
        cruiseLiner.setSpeed(50);
        str.append(cruiseLiner.move()).append("\n");

        Vehicle sedan = new Sedan();
        sedan.setSpeed(50);
        str.append(sedan.move()).append("\n");

        showPattern(str.toString());
    }

    @FXML
    public void onDecorator() {
        StringBuilder str = new StringBuilder();

        Vehicle train = new Train();
        train.setSpeed(20);
        Movable slowMovingTrain = new SlowMoveDecorator(train);
        str.append(slowMovingTrain.move()).append("\n");

        Vehicle plane = new Plane();
        plane.setSpeed(800);
        Movable fastMovingPlane = new FastMoveDecorator(plane);
        str.append(fastMovingPlane.move()).append("\n");

        showPattern(str.toString());
    }

    @FXML
    public void onCommand() {
        StringBuilder str = new StringBuilder();

        Vehicle truck = new Truck();
        truck.setSpeed(80);

        VehicleOperationExecutor vehicleOperationExecutor = new VehicleOperationExecutor();
        vehicleOperationExecutor.add(new RunVehicleOperation(truck));
        vehicleOperationExecutor.add(new StopVehicleOperation(truck));
        showPattern(vehicleOperationExecutor.execute());
    }

    public void showPattern(String str) {
        Label label = new Label(str);
        borderPane.setCenter(label);
    }
}
