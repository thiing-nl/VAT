package com.vat.gui.shape;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class ShapeScene {

    private Label testLabel;
    private int fieldCount = 0;
    private boolean pressedAdd = false;

    HashMap<String, Integer> createWindowAndShow(String text, HashMap<String, String> fields) {
        return createWindowAndShow(text, fields, new HashMap<>());
    }

    HashMap<String, Integer> createWindowAndShow(String text, HashMap<String, String> fields, HashMap<String, Integer> data) {
        HashMap<String, TextField> textFields = new HashMap<>();
        Stage window = new Stage();
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 30, 10, 30));

        VBox layout = new VBox(10);

        // Reset field count and reset grid
        fieldCount = 0;
        System.out.println(fields);
        layout.getChildren().removeAll(grid);

        for (HashMap.Entry<String, String> entry : fields.entrySet()) {
            Label fieldLabel = new Label(entry.getValue());
            grid.add(fieldLabel, 0, fieldCount);
            fieldCount++;

            TextField fieldInput = new TextField();
            fieldInput.setPrefWidth(240);
            fieldInput.setText(String.format("%d", data.getOrDefault(entry.getKey(), 0)));
            grid.add(fieldInput, 0, fieldCount);
            fieldCount++;

            fieldInput.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue,
                                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        fieldInput.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });

            textFields.put(entry.getKey(), fieldInput);
        }

        window.initModality(Modality.APPLICATION_MODAL);
        if(data.size() == 0) {
            window.setTitle("VAT - Vorm aanmaken");
        } else {
            window.setTitle("VAT - Vorm veranderen");
        }
        window.setMinWidth(300);
        window.setMinHeight(350);

        testLabel = new Label();
        testLabel.setText(text);
        Button closeButton = new Button("Annuleren");
        closeButton.setOnAction(e -> window.close());

        Button createButton;
        if(data.size() == 0) {
            createButton = new Button("Aanmaken");
        } else {
            createButton = new Button("Veranderen");
        }
        createButton.setOnAction(e -> {
            this.pressedAdd = true;
            window.close();
        });

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);
        buttons.getChildren().addAll(closeButton, createButton);

        layout.getChildren().addAll(testLabel, grid, buttons);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        System.out.println(this.pressedAdd);
        if (this.pressedAdd) {
            HashMap<String, Integer> returnData = new HashMap<>();

            for (HashMap.Entry<String, TextField> entry : textFields.entrySet()) {
                TextField textField = entry.getValue();
                returnData.put(entry.getKey(), Integer.parseInt(textField.getText()));
            }

            return returnData;
        }

        return null;
    }
}
