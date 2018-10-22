package com.vat.shape;

import java.util.HashMap;


public class Cube implements Shape {

    /**
     * Fields of the Cube
     */
    public static HashMap<String, String> fields = new HashMap<String, String>() {{
        put("width", "Breedte:");
    }};
    public final String type = "Cube";
    private int width;

    public Cube(int width) {
        this.setWidth(width);
    }

    @Override
    public HashMap<String, String> getFields() {
        return Cube.fields;
    }

    @Override
    public String getType() {
        return this.type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public HashMap<String, Integer> getData() {
        HashMap<String, Integer> data = new HashMap<>();

        data.put("width", this.width);

        return data;
    }

    @Override
    public void setData(HashMap<String, Integer> data) {
        this.width = data.getOrDefault("width", 0);
    }

    @Override
    public double calculateVolume() {
        return Math.pow(this.width, 3);
    }

    @Override
    public String toString() {
        return String.format("Kubus (breedte: %d)", width);
    }
}
