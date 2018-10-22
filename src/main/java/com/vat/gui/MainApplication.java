package com.vat.gui;

import com.vat.gui.data.LoadShapes;
import com.vat.gui.data.SaveShapes;
import com.vat.gui.shape.EditShape;
import com.vat.gui.shape.NewShape;
import com.vat.shape.Shape;
import com.vat.shape.ShapeService;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainApplication extends Application {

    public static ShapeService shapeService = new ShapeService();
    private Stage window;
    private ComboBox<String> shapeTypeComboBox;
    private ListView<String> shapeList;
    private TextField volumeText;
    private TextField totalVolumeText;
    private Button deleteButton;
    private Shape previousSelectedShape = null;
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
        VBox shapeTypeBox = this.createShapeTypeBox();

        // Volume
        VBox volumeBox = new VBox();
        Label volumeLabel = new Label("Inhoud: (m³)");
        volumeText = new TextField();
        volumeText.setPrefWidth(200.0);
        volumeText.setText("0.0");
        volumeText.setDisable(true);
        volumeBox.getChildren().addAll(volumeLabel, volumeText);

        // Total Volume
        VBox totalVolumeBox = new VBox();
        Label totalVolumeLabel = new Label("Totale Inhoud: (m³)");
        totalVolumeText = new TextField();
        totalVolumeText.setPrefWidth(200.0);
        totalVolumeText.setText("0.0");
        totalVolumeText.setDisable(true);
        totalVolumeBox.getChildren().addAll(totalVolumeLabel, totalVolumeText);

        leftPane.add(shapeTypeBox, 0, 0);
        leftPane.add(volumeBox, 0, 1);
        leftPane.add(totalVolumeBox, 0, 2);

        // Shape List Box
        VBox shapeListBox = new VBox();
        Label shapeListHeader = new Label("Figuren:");

        shapeList = new ListView<>();
        shapeList.setPrefWidth(300.0);
        shapeList.setOnMouseClicked(click -> {
            String selectedItem = shapeList.getSelectionModel()
                    .getSelectedItem();
            int selectedIndex = shapeList.getSelectionModel()
                    .getSelectedIndex();

            if (selectedItem == null) {
                return;
            }

            if (click.getClickCount() == 1) {
                System.out.println("selectedItem: " + selectedItem);
                System.out.println("this.previousSelectedItem: " + this.previousSelectedItem);
                if (this.previousSelectedItem != null && this.previousSelectedItem.equals(selectedItem)) {
                    this.previousSelectedItem = null;
                    this.previousSelectedShape = null;
                    volumeText.setText("0.0");
                    shapeListHeader.setText("Figuren:");
                    deleteButton.setDisable(true);
                    Platform.runLater(() -> shapeList.getSelectionModel().select(null));
                } else {
                    Shape shape = shapeService.getShapes().get(selectedIndex);
                    volumeText.setText(String.format("%s", shape.calculateVolume()));
                    this.previousSelectedItem = selectedItem;
                    this.previousSelectedShape = shape;
                    deleteButton.setDisable(false);
                    shapeListHeader.setText("Hint: Dubbelklikken voor bewerken.");
                }
            } else if (click.getClickCount() == 2) {
                window.hide();
                EditShape.display(shapeService.getShapes().get(selectedIndex));
                this.previousSelectedItem = null;
                this.previousSelectedShape = null;
                deleteButton.setDisable(true);
                shapeListHeader.setText("Figuren:");
                window.show();
                updateView();
            }
        });

        shapeListBox.getChildren().addAll(shapeListHeader, shapeList);

        deleteButton = new Button("Verwijder geselecteerde");
        deleteButton.setDisable(true);
        deleteButton.setOnAction(e -> {
            if (previousSelectedItem != null) {
                System.out.println(previousSelectedShape);
                System.out.println(shapeService.getShapes().indexOf(previousSelectedShape));
                shapeService.getShapes().remove(previousSelectedShape);
                previousSelectedShape = null;
                previousSelectedItem = null;
                deleteButton.setDisable(false);
                shapeListHeader.setText("Figuren:");

                this.updateView();
            }
        });

        rightPane.add(shapeListBox, 0, 0);
        rightPane.add(deleteButton, 0, 1);

        this.updateView();

        return editor;
    }

    private void updateView() {
        shapeList.getItems()
                .clear();

        ArrayList<String> shapes = new ArrayList<>();

        for (Shape shape :
                shapeService.getShapes()) {
            shapes.add(shape.toString());
        }

        volumeText.setText("0.0");
        totalVolumeText.setText(String.format("%s", shapeService.calculateVolume()));

        shapeList.getItems().addAll(shapes);
    }

    private VBox createShapeTypeBox() {
        VBox shapeTypeBox = new VBox();
        Label shapeTypeLabel = new Label("Aanmaken Figuur:");
        shapeTypeComboBox = new ComboBox<String>();
        shapeTypeComboBox.setPrefWidth(200.0);
        shapeTypeComboBox.setPromptText("Selecteer...");
        shapeTypeComboBox.getItems().addAll("Blok", "Bol", "Cilinder", "Kegel", "Kubus", "Piramide");
        shapeTypeComboBox
                .valueProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        System.out.println(newValue);
                        window.hide();

                        NewShape.display(newValue);
                        window.show();
                        this.updateView();
                        Platform.runLater(() -> shapeTypeComboBox.setValue(null));
                    }
                });

        shapeTypeBox.getChildren().addAll(shapeTypeLabel, shapeTypeComboBox);
        return shapeTypeBox;
    }

    private MenuBar createMenu() {
        Menu fileMenu = new Menu("Bestand");

        MenuItem load = new MenuItem("Inladen");
        load.setOnAction(e -> {
            window.hide();
            if (LoadShapes.display()) {
                window.show();
                this.updateView();
            }
        });

        MenuItem save = new MenuItem("Opslaan");
        save.setOnAction(e -> {
            window.hide();
            if (SaveShapes.display()) {
                window.show();
                this.updateView();
            }
        });

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
