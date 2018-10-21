package com.vat.service;

import com.vat.model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ShapeService {

    private ArrayList<Shape> shapes = new ArrayList<>();
    private int volume;

    public ArrayList<Shape> getShapes() {
        return this.shapes;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void calculateVolume() {
        // TODO - implement ShapeService.calculateVolume
        throw new UnsupportedOperationException();
    }

    /**
     * @param shape
     */
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    public Shape addShape(String shapeType, HashMap<String, Integer> data) {
        Shape newShape = null;

        switch(shapeType) {
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
                newShape = new Pyramid(data.get("ground"), data.get("height"));
                break;
            case "Prisma":
                newShape = new Prism(data.get("radius"), data.get("height"));
                break;
        }

        if(newShape != null) {
            this.shapes.add(newShape);
            return newShape;
        }

        return null;
    }

    public static HashMap<String, String> getFields(String shapeType) {
        switch(shapeType) {
            case "Blok":
                return Cuboid.getFields();
            case "Bol":
                return Sphere.getFields();
            case "Cilinder":
                return Cylinder.getFields();
            case "Kegel":
                return Cone.getFields();
            case "Kubus":
                return Cube.getFields();
            case "Piramide":
                return Pyramid.getFields();
            case "Prisma":
                return Prism.getFields();
            default:
                return null;
        }
    }

    /**
     * Save all current shapes to the database
     */
    public void saveSQL() {
        // TODO - implement ShapeService.saveSQL
        throw new UnsupportedOperationException();
    }

    /**
     * @param path
     */
    public void saveJSON(String path) {
        // TODO - implement ShapeService.saveJSON
        throw new UnsupportedOperationException();
    }

    /**
     * @param path
     */
    public void saveText(String path) {
        // TODO - implement ShapeService.saveText
        throw new UnsupportedOperationException();
    }

    public void loadSQL() {
        // TODO - implement ShapeService.loadSQL
        throw new UnsupportedOperationException();
    }

    /**
     * @param path
     */
    public void loadJSON(String path) {
        // TODO - implement ShapeService.loadJSON
        throw new UnsupportedOperationException();
    }

    /**
     * @param path
     */
    public void loadText(String path) {
        // TODO - implement ShapeService.loadText
        throw new UnsupportedOperationException();
    }

}