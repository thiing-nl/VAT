package com.vat.model;

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

    private int length;
    private int width;
    private int height;

    public Pyramid(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public HashMap<String, String> getFields() {
        return Pyramid.fields;
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
    public HashMap<String, Integer> getData() {
        HashMap<String, Integer> data = new HashMap<>();

        data.put("length", this.length);
        data.put("height", this.height);
        data.put("width", this.width);

        return data;
    }

    @Override
    public void setData(HashMap<String, Integer> data) {
        this.length = data.getOrDefault("length", 0);
        this.height = data.getOrDefault("height", 0);
        this.width = data.getOrDefault("width", 0);
    }

    @Override
    public double calculateVolume() {
        return ((width * length) * height) / 3.0;
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

    @Override
    public String toString() {
        return String.format("Piramide (lengte: %d, breedte: %d, hoogte: %d)", length, width, height);
    }
}
