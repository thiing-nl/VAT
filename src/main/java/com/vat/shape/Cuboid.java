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
     * @param length
     * @param width
     * @param height
     */
    public Cuboid(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public HashMap<String, String> getFields() {
        return Cuboid.fields;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
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

        data.put("length", this.length);
        data.put("width", this.width);
        data.put("height", this.height);

        return data;
    }

    @Override
    public void setData(HashMap<String, Integer> data) {
        this.length = data.getOrDefault("length", 0);
        this.width = data.getOrDefault("width", 0);
        this.height = data.getOrDefault("height", 0);
    }

    @Override
    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

    @Override
    public String toString() {
        return String.format("Blok (lengte: %d, breedte: %d, hoogte: %d)", length, width, height);
    }
}