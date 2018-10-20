package com.vat.gui;

import com.sun.javafx.scene.control.skin.LabeledText;
import com.vat.gui.data.LoadShapes;
import com.vat.gui.data.SaveShapes;
import com.vat.gui.shape.NewShape;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApplication extends Application {

    private Stage window;
    private ComboBox<String> shapeTypeComboBox;
    private String previousSelectedItem = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("VAT");

        BorderPane borderPane = new BorderPane();

        MenuBar menuBar = this.createMenu();
        GridPane editor = this.createEditor();

        borderPane.setTop(menuBar);
        borderPane.setCenter(editor);

        Scene scene = new Scene(borderPane, 500, 250);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    private GridPane createEditor() {
        GridPane editor = new GridPane();
        ColumnConstraints leftColumnConstraint = new ColumnConstraints();
        leftColumnConstraint.setPercentWidth(40);
        ColumnConstraints rightColumnConstraint = new ColumnConstraints();
        rightColumnConstraint.setPercentWidth(60);
        editor.getColumnConstraints().addAll(leftColumnConstraint, rightColumnConstraint);

        editor.setPadding(new Insets(20));
        editor.setVgap(8);
        editor.setHgap(20);
        GridPane leftPane = new GridPane();
        leftPane.setVgap(10);
        GridPane rightPane = new GridPane();
        rightPane.setVgap(10);

        editor.add(leftPane, 0, 0);
        editor.add(rightPane, 1, 0);

        // Left Pane

        // Shape Selector
        VBox shapeTypeBox = new VBox();
        Label shapeTypeLabel = new Label("Aanmaken Figuur:");
        shapeTypeComboBox = new ComboBox<String>();
        shapeTypeComboBox.setPrefWidth(200.0);
        shapeTypeComboBox.setPromptText("Selecteer...");
        shapeTypeComboBox.getItems().addAll("Blok", "Bol", "Cilinder", "Kegel", "Kubus", "Piramide", "Prisma");
        shapeTypeComboBox
                .valueProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        System.out.println(newValue);
                        window.hide();
                        if (NewShape.display(newValue)) {
                            window.show();
                        }
                        Platform.runLater(() -> shapeTypeComboBox.setValue(null));
                    }
                });

        shapeTypeBox.getChildren().addAll(shapeTypeLabel, shapeTypeComboBox);

        // Volume
        VBox volumeBox = new VBox();
        Label volumeLabel = new Label("Inhoud:");
        TextField volumeText = new TextField();
        volumeText.setPrefWidth(200.0);
        volumeText.setText("0.0");
        volumeBox.getChildren().addAll(volumeLabel, volumeText);

        // Volume
        VBox totalVolumeBox = new VBox();
        Label totalVolumeLabel = new Label("Totale Inhoud:");
        TextField totalVolumeText = new TextField();
        totalVolumeText.setPrefWidth(200.0);
        totalVolumeText.setText("0.0");
        totalVolumeBox.getChildren().addAll(totalVolumeLabel, totalVolumeText);

        leftPane.add(shapeTypeBox, 0, 0);
        leftPane.add(volumeBox, 0, 1);
        leftPane.add(totalVolumeBox, 0, 2);

        VBox shapeListBox = new VBox();
        Label shapeListHeader = new Label("Figuren:");

        ListView<String> shapeList = new ListView<>();
        shapeList.setPrefWidth(300.0);
        shapeList.getItems().addAll("Test 1", "Test 2", "Test 3");
//        shapeList.getSelectionModel()
//                .selectedIndexProperty()
//                .addListener((observable, oldValue, newValue) -> {
//                    System.out.println(oldValue);
//                    System.out.println(newValue);
//                    shapeListHeader.setVisible(true);
//                });
        shapeList.setOnMouseClicked(click -> {
            String selectedItem = shapeList.getSelectionModel()
                    .getSelectedItem();

            if(this.previousSelectedItem == null) {
                this.previousSelectedItem = selectedItem;
            } else if(this.previousSelectedItem.equals(selectedItem)) {
//                Platform.runLater(shapeList.getSelectionModel().set);
            }

            if (click.getClickCount() == 2) {

            }
        });

        shapeListBox.getChildren().addAll(shapeListHeader, shapeList);

        rightPane.add(shapeListBox, 0, 0);

        return editor;
    }

    private MenuBar createMenu() {
        Menu fileMenu = new Menu("Bestand");

        MenuItem load = new MenuItem("Inladen");
        load.setOnAction(e -> LoadShapes.display());

        MenuItem save = new MenuItem("Opslaan");
        save.setOnAction(e -> SaveShapes.display());

        MenuItem close = new MenuItem("Afsluiten");
        close.setOnAction(e -> window.close());

        fileMenu.getItems()
                .addAll(
                        load,
                        save,
                        new SeparatorMenuItem(),
                        close
                );

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);

        return menuBar;
    }
}
