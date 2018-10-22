package com.vat.shape;

import java.util.ArrayList;
import java.util.HashMap;

public class ShapeService {

    /**
     * All Shapes in the Shape Service
     */
    private ArrayList<Shape> shapes = new ArrayList<>();

    /**
     * Get the fields for a ShapeType
     *
     * @param shapeType - shapeType in String
     * @return - HashMap containing the field with the label text
     */
    public static HashMap<String, String> getFields(String shapeType) {
        switch (shapeType) {
            case "Blok":
                return Cuboid.fields;
            case "Bol":
                return Sphere.fields;
            case "Cilinder":
                return Cylinder.fields;
            case "Kegel":
                return Cone.fields;
            case "Kubus":
                return Cube.fields;
            case "Piramide":
                return Pyramid.fields;
            default:
                return null;
        }
    }

    /**
     * Get all current shapes
     *
     * @return - Shapes
     */
    public ArrayList<Shape> getShapes() {
        return this.shapes;
    }

    /**
     * Set the Shapes
     *
     * @param shapes
     */
    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    /**
     * Calculate the Volume for all of the Shapes in the ShapeService
     *
     * @return
     */
    public double calculateTotalVolume() {
        double totalVolume = 0.0;

        for (Shape shape : shapes) {
            totalVolume += shape.calculateVolume();
        }

        return totalVolume;
    }

    /**
     * Adds a Shape to the Shapes list
     *
     * @param shape - Shape to add
     */
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    /**
     * Add Shape to the Shape
     *
     * @param shapeType - Shape Type in String
     * @param data      - HashMap of data to create the shapes from
     * @return - Returns the created Shape
     */
    public Shape addShape(String shapeType, HashMap<String, Integer> data) {
        Shape newShape;

        switch (shapeType) {
            case "Blok":
                newShape = new Cuboid(data.get("length"), data.get("width"), data.get("height"));
                break;
            case "Bol":
                newShape = new Sphere(data.get("radius"));
                break;
            case "Cilinder":
                newShape = new Cylinder(data.get("radius"), data.get("height"));
                break;
            case "Kegel":
                newShape = new Cone(data.get("radius"), data.get("height"));
                break;
            case "Kubus":
                newShape = new Cube(data.get("width"));
                break;
            case "Piramide":
                newShape = new Pyramid(data.get("length"), data.get("width"), data.get("height"));
                break;
            default:
                return null;
        }

        this.shapes.add(newShape);
        return newShape;
    }
}