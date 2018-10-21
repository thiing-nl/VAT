package com.vat.model;

import java.util.HashMap;

public class Cone implements Shape {

    /**
     * Fields of the Cone
     */
    public static HashMap<String, String> fields = new HashMap<String, String>() {{
        put("radius", "Radius:");
        put("height", "Hoogte:");
    }};

    private int radius;
    private int height;

    public Cone(int radius, int height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public HashMap<String, String> getFields() {
        return Cone.fields;
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

    @Override
    public String toString() {
        return "Cone{" +
                "radius=" + radius +
                ", height=" + height +
                '}';
    }
}
