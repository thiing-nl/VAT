package com.vat.gui.shape;

public class NewShape {
    public static boolean display(String shapeType) {
        ShapeScene scene = new ShapeScene();
        return scene.createWindowAndShow("New Shape: " + shapeType);
    }
}
