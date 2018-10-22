package com.vat.gui.data;

import com.vat.data.SQLStorage;
import com.vat.data.StorageService;
import com.vat.gui.MainApplication;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.util.Date;

class DataScene {

    static final String DATA_SCENE_TYPE_LOAD = "DATA_SCENE_TYPE_LOAD";
    static final String DATA_SCENE_TYPE_SAVE = "DATA_SCENE_TYPE_SAVE";
    private static StorageService storageService = new StorageService();
    private static Stage window;
    private static FileChooser fileChooser;
    private static ToggleGroup toggleGroup;

    static void createWindowAndShow(String type) {
        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(300);
        window.setMinHeight(200);

        Label label = new Label();

        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);
        layout.setPadding(new Insets(30));
        layout.getChildren().add(label);

        HBox toggle = new HBox();
        toggle.setSpacing(10);
        toggle.setAlignment(Pos.CENTER);

        toggleGroup = createToggleGroup(toggle);

        Button closeButton = new Button("Annuleren");
        closeButton.setOnAction(e -> window.close());

        Button rightButton = new Button();

        switch (type) {
            case DATA_SCENE_TYPE_LOAD:
                window.setTitle("VAT - Inladen");
                label.setText("Selecteer inlaad manier:");
                rightButton.setText("Inladen");
                rightButton.setOnAction(e -> load());
                break;
            case DATA_SCENE_TYPE_SAVE:
                window.setTitle("VAT - Opslaan");
                label.setText("Selecteer opslaan manier:");
                rightButton.setText("Opslaan");
                rightButton.setOnAction(e -> save());
                break;
        }

        HBox buttons = new HBox(10);
        buttons.getChildren().addAll(closeButton, rightButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(20,0,0,0));

        layout.getChildren().addAll(toggle, buttons);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    /**
     * Creating a new Toggle Group
     *
     * @param toggle
     * @return
     */
    private static ToggleGroup createToggleGroup(HBox toggle) {
        ToggleGroup toggleGroup = new ToggleGroup();

        toggleGroup.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            if (toggleGroup.getSelectedToggle() == null) {
                toggleGroup.getToggles().get(0).setSelected(true);
            }
        });

        ToggleButton tb1 = new ToggleButton("Tekst");
        tb1.setUserData(StorageService.STORAGE_TYPE_TEXT);
        tb1.setToggleGroup(toggleGroup);
        tb1.setSelected(true);

        ToggleButton tb2 = new ToggleButton("Objecten");
        tb2.setUserData(StorageService.STORAGE_TYPE_OBJECT);
        tb2.setToggleGroup(toggleGroup);

        ToggleButton tb3 = new ToggleButton("SQL");
        tb3.setUserData(StorageService.STORAGE_TYPE_SQL);
        tb3.setToggleGroup(toggleGroup);
        tb3.setDisable(!SQLStorage.canMakeConnection());
        toggle.getChildren().addAll(tb1, tb2, tb3);

        return toggleGroup;
    }

    private static void save() {
        fileChooser = new FileChooser();
        switch ((String) toggleGroup.getSelectedToggle().getUserData()) {
            case StorageService.STORAGE_TYPE_TEXT:
                fileChooser.setTitle("Open Text File");
                fileChooser.getExtensionFilters().clear();
                fileChooser.setInitialFileName(String.format("VAT-Text-%d.json", new Date().getTime()));
                File textFile = fileChooser.showSaveDialog(window);

                if (textFile == null) {
                    System.out.println("User cancelled");
                } else {
                    try {
                        storageService.getStorage(StorageService.STORAGE_TYPE_TEXT)
                                .saveData(textFile.toString(), MainApplication.shapeService.getShapes());
                        window.close();
                    } catch (Exception err) {
                        showAlert(err.getLocalizedMessage());
                        err.printStackTrace();
                    }
                }

                break;
            case StorageService.STORAGE_TYPE_OBJECT:
                fileChooser.setTitle("Open Object File");
                fileChooser.getExtensionFilters().clear();
                fileChooser.setInitialFileName(String.format("VAT-Object-%d.vat", new Date().getTime()));
                File objectFile = fileChooser.showSaveDialog(window);

                if (objectFile == null) {
                    System.out.println("User cancelled");
                } else {
                    try {
                        storageService.getStorage(StorageService.STORAGE_TYPE_OBJECT)
                                .saveData(objectFile.toString(), MainApplication.shapeService.getShapes());
                        window.close();
                    } catch (Exception err) {
                        showAlert(err.getLocalizedMessage());
                        err.printStackTrace();
                    }
                }

                System.out.println(objectFile);

                break;
            case StorageService.STORAGE_TYPE_SQL:
                try {
                    storageService.getStorage(StorageService.STORAGE_TYPE_SQL)
                            .saveData(MainApplication.shapeService.getShapes());
                    window.close();
                } catch (Exception err) {
                    showAlert(err.getLocalizedMessage());
                    err.printStackTrace();
                }

                break;
        }
    }

    private static void load() {
        fileChooser = new FileChooser();
        switch ((String) toggleGroup.getSelectedToggle().getUserData()) {
            case StorageService.STORAGE_TYPE_TEXT:
                fileChooser.setTitle("Open Text File");
                fileChooser.getExtensionFilters().clear();
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.json bestand", "*.json"));
                fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator")));
                File textFile = fileChooser.showOpenDialog(window);

                if (textFile == null) {
                    System.out.println("User cancelled");
                } else {
                    try {
                        MainApplication.shapeService.setShapes(
                                storageService.getStorage(StorageService.STORAGE_TYPE_TEXT)
                                        .loadData(textFile.toString())
                        );
                        window.close();
                    } catch (Exception err) {
                        showAlert(err.getLocalizedMessage());
                        err.printStackTrace();
                    }
                }

                break;
            case StorageService.STORAGE_TYPE_OBJECT:
                fileChooser.setTitle("Open Object File");
                fileChooser.getExtensionFilters().clear();
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.vat bestand", "*.vat"));
                fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator")));
                File objectFile = fileChooser.showOpenDialog(window);

                if (objectFile == null) {
                    System.out.println("User cancelled");
                } else {
                    try {
                        MainApplication.shapeService.setShapes(
                                storageService.getStorage(StorageService.STORAGE_TYPE_OBJECT)
                                        .loadData(objectFile.toString())
                        );
                        window.close();
                    } catch (Exception err) {
                        showAlert(err.getLocalizedMessage());
                        err.printStackTrace();
                    }
                }

                break;
            case StorageService.STORAGE_TYPE_SQL:
                try {
                    MainApplication.shapeService.setShapes(
                            storageService.getStorage(StorageService.STORAGE_TYPE_SQL)
                                    .loadData()
                    );
                    window.close();
                } catch (Exception err) {
                    showAlert(err.getLocalizedMessage());
                    err.printStackTrace();
                }

                break;
        }
    }

    private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }
}
