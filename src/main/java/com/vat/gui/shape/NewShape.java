package com.vat.gui.shape;

import com.vat.gui.MainApplication;
import com.vat.shape.Shape;
import com.vat.shape.ShapeService;

import java.util.HashMap;

public class NewShape {

    public static Shape display(String shapeType) {
        ShapeScene scene = new ShapeScene();

        HashMap<String, Integer> data = scene.createWindowAndShow("Vorm aanmaken: " + shapeType, ShapeService.getFields(shapeType));

        if (data == null) {
            return null;
        }

        return MainApplication.shapeService.addShape(shapeType, data);
    }

}
