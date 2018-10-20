package com.vat.gui.shape;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

class ShapeScene {

    private Label testLabel;

    boolean createWindowAndShow() {
        return this.createWindowAndShow("Test label!");
    }

    boolean createWindowAndShow(String text) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("VAT - Load / Save");
        window.setMinWidth(300);
        window.setMinHeight(300);

        testLabel = new Label();
        testLabel.setText(text);
        Button closeButton = new Button("Close this window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(testLabel, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return true;
    }
}
