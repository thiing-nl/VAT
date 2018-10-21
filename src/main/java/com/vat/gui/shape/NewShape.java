package com.vat.gui.shape;

import com.vat.model.*;

import java.util.HashMap;

public class NewShape {
    public static boolean display(String shapeType) {
        ShapeScene scene = new ShapeScene();
        HashMap<String, String> fields = new HashMap<>();

        switch(shapeType) {
            case "Blok":
                fields = Cuboid.getFields();
                break;
            case "Bol":
                fields = Sphere.getFields();
                break;
            case "Cilinder":
                fields = Cylinder.getFields();
                break;
            case "Kegel":
                fields = Cone.getFields();
                break;
            case "Kubus":
                fields = Cube.getFields();
                break;
            case "Piramide":
                fields = Pyramid.getFields();
                break;
            case "Prisma":
                fields = Prism.getFields();
                break;
        }

        return scene.createWindowAndShow("Vorm aanmaken: " + shapeType, fields);
    }
}
