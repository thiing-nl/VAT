package com.vat.gui.shape;

import com.vat.model.Shape;

import java.util.HashMap;

public class EditShape extends ShapeScene {
    public static Shape display(Shape shape) {
        ShapeScene scene = new ShapeScene();
        System.out.println("Shape: " + shape);

        HashMap<String, Integer> data = scene.createWindowAndShow("123", shape.getFields(), shape.getData());

        shape.setData(data);

        return shape;
    }
}
