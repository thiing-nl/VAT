package com.vat.model;

import java.util.HashMap;

public class Pyramid implements Shape {

    /**
     * Fields of the Pyramid
     */
    public static HashMap<String, String> fields = new HashMap<String, String>() {{
        put("ground", "Grondvlak:");
        put("height", "Hoogte:");
    }};

    private int ground;
    private int height;

    public Pyramid(int ground, int height) {
        this.ground = ground;
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

        data.put("ground", this.ground);
        data.put("height", this.height);

        return data;
    }

    @Override
    public void setData(HashMap<String, Integer> data) {
        this.ground = data.getOrDefault("ground", 0);
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
        return "Pyramid{" +
                "ground=" + ground +
                ", height=" + height +
                '}';
    }
}
