package com.vat.model;

import com.vat.model.Shape;

public class Sphere implements Shape {

    /**
     * Radius of the Sphere
     */
    private int radius;

    /**
     * @param radius
     */
    public Sphere(int radius) {
        // TODO - implement Sphere.Sphere
        throw new UnsupportedOperationException();
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
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