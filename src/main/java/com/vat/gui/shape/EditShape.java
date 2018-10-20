package com.vat.gui.shape;

public class EditShape extends ShapeScene {
    private static String type;

    void display(String type) {
        EditShape.type = type;
        this.createWindowAndShow();
    }
}
