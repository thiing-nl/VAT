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
     * Creating a Cylinder with Length, Width and Height
     *
     * @param radius - Radius of the Cylinder
     * @param height - Height of the Cylinder
     */
    public Cylinder(int radius, int height) {
        this.setRadius(radius);
        this.setHeight(height);
    }

    /**
     * Receives the Radius of the Cylinder
     *
     * @return Radius of Cylinder
     */
    public int getRadius() {
        return this.radius;
    }

    /**
     * Setting the Length of the Cylinder
     *
     * @param radius - Radius of the Cylinder
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Receives the Height of the Cylinder
     *
     * @return Radius of Height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Setting the Height of the Cylinder
     *
     * @param height - Height of the Cylinder
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Receiving all fields for the Cylinder
     *
     * @return All fields
     */
    @Override
    public HashMap<String, String> getFields() {
        return Cylinder.fields;
    }

    /**
     * Receiving the type representation of Cylinder in String
     *
     * @return Type representation in String
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Converts the Cylinder into a data HashMap
     *
     * @return Data HashMap
     */
    @Override
    public HashMap<String, Integer> getData() {
        HashMap<String, Integer> data = new HashMap<>();

        data.put("radius", this.radius);
        data.put("height", this.height);

        return data;
    }

    /**
     * Converts a data HashMap into the properties of the Cylinder
     *
     * @param data - HashMap with the data
     */
    @Override
    public void setData(HashMap<String, Integer> data) {
        this.radius = data.getOrDefault("radius", 0);
        this.height = data.getOrDefault("height", 0);
    }

    /**
     * Calculate Volume of the Cylinder
     *
     * @return Volume of the Cylinder
     */
    @Override
    public double calculateVolume() {
        return Math.PI * Math.pow(this.radius, 2) * this.height;
    }

    /**
     * Convert the Cylinder into a string representation
     * e.g for showing in the list
     *
     * @return String representation of the Cylinder
     */
    @Override
    public String toString() {
        return String.format("Cilinder (radius: %d, hoogte: %d)", radius, height);
    }
}