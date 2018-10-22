package com.vat.shape;


import java.util.HashMap;

public class Cone implements Shape {

    /**
     * Fields of the Cone
     */
    public static HashMap<String, String> fields = new HashMap<String, String>() {{
        put("radius", "Radius:");
        put("height", "Hoogte:");
    }};

    /**
     * Type of the shape
     */
    public final String type = "Cone";

    /**
     * Radius of the Cone
     */
    private int radius;

    /**
     * Height of the Cone
     */
    private int height;

    /**
     * Creating a Cone with Radius and Height
     *
     * @param radius - Radius of the Cone
     * @param height - Height of the Cone
     */
    public Cone(int radius, int height) {
        this.setRadius(radius);
        this.setHeight(height);
    }

    /**
     * Receives the radius of the Cone
     *
     * @return Radius of Cone
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Sets the Radius for the cone.
     *
     * @param radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Receives the Height of the Cone
     *
     * @return Height of the Cone
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setting the Height of the Cone
     *
     * @param height - Height of the Cone
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Receiving all fields for the Cone
     *
     * @return All fields
     */
    @Override
    public HashMap<String, String> getFields() {
        return Cone.fields;
    }

    /**
     * Receiving the type representation of Cone in String
     *
     * @return Type representation in String
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Converts the Cone into a data HashMap
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
     * Converts a data HashMap into the properties of the Cone
     *
     * @param data - HashMap with the data
     */
    @Override
    public void setData(HashMap<String, Integer> data) {
        this.radius = data.getOrDefault("radius", 0);
        this.height = data.getOrDefault("height", 0);
    }

    /**
     * Calculate Volume of the Cone
     *
     * @return Volume of the Cone
     */
    @Override
    public double calculateVolume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(this.radius, 2) * this.height;
    }

    /**
     * Convert the Cone into a string representation
     * e.g for showing in the list
     *
     * @return String representation of the Cone
     */
    @Override
    public String toString() {
        return String.format("Kegel (radius: %d, hoogte: %d)", radius, height);
    }
}
