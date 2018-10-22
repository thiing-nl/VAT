package com.vat.shape;


import java.util.HashMap;

public class Cuboid implements Shape {

    /**
     * Fields of the Cuboid
     */
    public static HashMap<String, String> fields = new HashMap<String, String>() {{
        put("length", "Lengte:");
        put("width", "Breedte:");
        put("height", "Hoogte:");
    }};

    /**
     * Type of the Shape
     */
    public final String type = "Cuboid";

    /**
     * Length of the Cuboid
     */

    private int length;

    /**
     * Width of the Cuboid
     */

    private int width;

    /**
     * Height of the Cuboid
     */
    private int height;

    /**
     * Creating a Cuboid with Length, Width and Height
     *
     * @param length - Length of the Cuboid
     * @param width  - Width of the Cuboid
     * @param height - Height of the Cuboid
     */
    public Cuboid(int length, int width, int height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    /**
     * Receives the Length of the Cuboid
     *
     * @return Length of Cuboid
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Setting the Length of the Cuboid
     *
     * @param length - Length of the Cuboid
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Receives the Width of the Cuboid
     *
     * @return Width of Cuboid
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Setting the Width of the Cuboid
     *
     * @param width - Width of the Cuboid
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Receives the Height of the Cuboid
     *
     * @return Height of Cuboid
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Setting the Height of the Cuboid
     *
     * @param height - Height of the Cuboid
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Receiving all fields for the Cuboid
     *
     * @return All fields
     */
    @Override
    public HashMap<String, String> getFields() {
        return Cuboid.fields;
    }

    /**
     * Receiving the type representation of Cuboid in String
     *
     * @return Type representation in String
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Converts the Cuboid into a data HashMap
     *
     * @return Data HashMap
     */
    @Override
    public HashMap<String, Integer> getData() {
        HashMap<String, Integer> data = new HashMap<>();

        data.put("length", this.length);
        data.put("width", this.width);
        data.put("height", this.height);

        return data;
    }

    /**
     * Converts a data HashMap into the properties of the Cuboid
     *
     * @param data - HashMap with the data
     */
    @Override
    public void setData(HashMap<String, Integer> data) {
        this.length = data.getOrDefault("length", 0);
        this.width = data.getOrDefault("width", 0);
        this.height = data.getOrDefault("height", 0);
    }

    /**
     * Calculate Volume of the Cuboid
     *
     * @return Volume of the Cuboid
     */
    @Override
    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

    /**
     * Convert the Cuboid into a string representation
     * e.g for showing in the list
     *
     * @return String representation of the Cuboid
     */
    @Override
    public String toString() {
        return String.format("Blok (lengte: %d, breedte: %d, hoogte: %d)", length, width, height);
    }
}