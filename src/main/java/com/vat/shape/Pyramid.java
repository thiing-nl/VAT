package com.vat.shape;


import java.util.HashMap;

public class Pyramid implements Shape {

    /**
     * Fields of the Pyramid
     */
    public static HashMap<String, String> fields = new HashMap<String, String>() {{
        put("length", "Lengte:");
        put("width", "Breedte:");
        put("height", "Hoogte:");
    }};

    /**
     * Type of the Shape
     */
    public final String type = "Pyramid";

    /**
     * Length of the Pyramid
     */
    private int length;

    /**
     * Width of the Pyramid
     */
    private int width;

    /**
     * Height of the Pyramid
     */
    private int height;

    /**
     * Creating a Pyramid with Length, Width and Height
     *
     * @param length - Length of the Pyramid
     * @param width  - Width of the Pyramid
     * @param height - Height of the Pyramid
     */
    public Pyramid(int length, int width, int height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    /**
     * Setting the Length of the Pyramid
     * @param length - Length of the Pyramid
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Setting the Width of the Pyramid
     * @param width - Width of the Pyramid
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Setting the Height of the Pyramid
     * @param height - Height of the Pyramid
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Receiving all fields for the Pyramid
     * @return - All fields
     */
    @Override
    public HashMap<String, String> getFields() {
        return Pyramid.fields;
    }

    /**
     * Receiving the type representation of Pyramid in String
     * @return - Type representation in String
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Converts the Pyramid into a data HashMap
     * @return - Data HashMap
     */
    @Override
    public HashMap<String, Integer> getData() {
        HashMap<String, Integer> data = new HashMap<>();

        data.put("length", this.length);
        data.put("height", this.height);
        data.put("width", this.width);

        return data;
    }

    /**
     * Converts a data HashMap into the properties of the Pyramid
     * @param data
     */
    @Override
    public void setData(HashMap<String, Integer> data) {
        this.length = data.getOrDefault("length", 0);
        this.height = data.getOrDefault("height", 0);
        this.width = data.getOrDefault("width", 0);
    }

    /**
     * Calculate Volume
     * @return - Volume of the Pyramid
     */
    @Override
    public double calculateVolume() {
        return ((width * length) * height) / 3.0;
    }

    /**
     * Convert the Pyramid into a string representation
     * e.g used for the list
     * @return - String representation of the Pyramid
     */
    @Override
    public String toString() {
        return String.format("Piramide (lengte: %d, breedte: %d, hoogte: %d)", length, width, height);
    }
}
