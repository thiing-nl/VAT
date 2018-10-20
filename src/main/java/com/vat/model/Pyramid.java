package com.vat.model;

import java.util.HashMap;

public class Pyramid implements Shape {

    /**
     * Fields of the Pyramid
     */
    private static HashMap<String, String> fields = new HashMap<String, String>() {{
        put("ground", "Grondvlak:");
        put("height", "Hoogte:");
    }};

    public static HashMap<String, String> getFields() {
        return fields;
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
}
