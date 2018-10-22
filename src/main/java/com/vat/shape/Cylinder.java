package com.vat.shape;


import java.util.HashMap;

public class Cylinder implements Shape {

    /**
     * Fields of the Cylinder
     */
    public static HashMap<String, String> fields = new HashMap<String, String>() {{
        put("radius", "Radius:");
        put("height", "Hoogte:");
    }};
    public final String type = "Cylinder";
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
        this.setRadius(radius);
        this.setHeight(height);
    }

    @Override
    public HashMap<String, String> getFields() {
        return Cylinder.fields;
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
    public String getType() {
        return this.type;
    }

    @Override
    public HashMap<String, Integer> getData() {
        HashMap<String, Integer> data = new HashMap<>();

        data.put("radius", this.radius);
        data.put("height", this.height);

        return data;
    }

    @Override
    public void setData(HashMap<String, Integer> data) {
        this.radius = data.getOrDefault("radius", 0);
        this.height = data.getOrDefault("height", 0);
    }

    @Override
    public double calculateVolume() {
        return Math.PI * Math.pow(this.radius, 2) * this.height;
    }

    @Override
    public String toString() {
        return String.format("Cilinder (radius: %d, hoogte: %d)", radius, height);
    }
}