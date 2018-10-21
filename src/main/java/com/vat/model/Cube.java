package com.vat.model;

import com.vat.model.Shape;

import java.util.HashMap;


public class Cube implements Shape {

    /**
     * Fields of the Cube
     */
    public static HashMap<String, String> fields = new HashMap<String, String>() {{
        put("width", "Breedte:");
    }};

    private int width;

    public Cube(int width) {
        this.width = width;
    }

    @Override
    public HashMap<String, String> getFields() {
        return Cube.fields;
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
        return String.format("Kubus (breedte: %d)", width);
    }
}
