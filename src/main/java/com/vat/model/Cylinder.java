package com.vat.model;

import com.vat.model.Shape;

public class Cylinder implements Shape {

    /**
     * Radius of the Cylinder
     */
    private int radius;
    /**
     * Height of the Cylinder
     */
    private int height;

    /**
     * @param radius
     * @param height
     */
    public Cylinder(int radius, int height) {
        // TODO - implement Cylinder.Cylinder
        throw new UnsupportedOperationException();
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void setType(String type) {

    }

    @Override
    public double calculateVolume() {
        return 0;
    }

    @Override
    public String toJSON() {
        return null;
    }

    @Override
    public void saveSQL() {

    }

    @Override
    public void loadJSON(int jsonObject) {

    }

    @Override
    public void loadSQL(int id) {

    }

    @Override
    public void loadString(String text) {

    }
}