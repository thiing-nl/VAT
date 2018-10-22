package com.vat.shape;

import java.util.HashMap;


public class Cube implements Shape {

    /**
     * Fields of the Cube
     */
    public static HashMap<String, String> fields = new HashMap<String, String>() {{
        put("width", "Breedte:");
    }};

    /**
     * Type of the Shape
     */
    public final String type = "Cube";

    /**
     * Width of the Cube
     */
    private int width;

    /**
     * Creating a Cube with the Width
     *
     * @param width - Width of the Cube
     */
    public Cube(int width) {
        this.setWidth(width);
    }

    /**
     * Receives the Width of the Cube
     *
     * @return Width of Cube
     */
    public int getWidth() {
        return width;
    }

    /**
     * Setting the Width of the Cube
     *
     * @param width - Width of the Cube
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Receiving all fields for the Cube
     *
     * @return All fields
     */
    @Override
    public HashMap<String, String> getFields() {
        return Cube.fields;
    }

    /**
     * Receiving the type representation of Cube in String
     *
     * @return Type representation in String
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Converts the Cube into a data HashMap
     *
     * @return Data HashMap
     */
    @Override
    public HashMap<String, Integer> getData() {
        HashMap<String, Integer> data = new HashMap<>();

        data.put("width", this.width);

        return data;
    }

    /**
     * Converts a data HashMap into the properties of the Cube
     *
     * @param data - HashMap with the data
     */
    @Override
    public void setData(HashMap<String, Integer> data) {
        this.width = data.getOrDefault("width", 0);
    }

    /**
     * Calculate Volume of the Cube
     *
     * @return Volume of the Cube
     */
    @Override
    public double calculateVolume() {
        return Math.pow(this.width, 3);
    }

    /**
     * Convert the Cube into a string representation
     * e.g for showing in the list
     *
     * @return String representation of the Cube
     */
    @Override
    public String toString() {
        return String.format("Kubus (breedte: %d)", width);
    }
}
