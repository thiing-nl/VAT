package com.vat.shape;


import java.util.HashMap;

public class Sphere implements Shape {


    /**
     * Fields of the Sphere
     */
    public static HashMap<String, String> fields = new HashMap<String, String>() {{
        put("radius", "Radius:");
    }};

    /**
     * Type of the Shape
     */
    public final String type = "Sphere";

    /**
     * Radius of the Sphere
     */
    private int radius;

    /**
     * Creating a Sphere with Radius
     *
     * @param radius - Length of the Sphere
     */
    public Sphere(int radius) {
        this.setRadius(radius);
    }

    /**
     * Receives the Radius of the Sphere
     *
     * @return Radius of Sphere
     */
    public int getRadius() {
        return this.radius;
    }

    /**
     * Setting the Radius of the Sphere
     *
     * @param radius - Radius of the Sphere
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Receiving all fields for the Sphere
     *
     * @return All fields
     */
    @Override
    public HashMap<String, String> getFields() {
        return Sphere.fields;
    }

    /**
     * Receiving the type representation of Sphere in String
     *
     * @return Type representation in String
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Converts the Sphere into a data HashMap
     *
     * @return Data HashMap
     */
    @Override
    public HashMap<String, Integer> getData() {
        HashMap<String, Integer> data = new HashMap<>();

        data.put("radius", this.radius);

        return data;
    }

    /**
     * Converts a data HashMap into the properties of the Sphere
     *
     * @param data - HashMap with the data
     */
    @Override
    public void setData(HashMap<String, Integer> data) {
        this.radius = data.getOrDefault("radius", 0);
    }

    /**
     * Calculate Volume of the Sphere
     *
     * @return Volume of the Sphere
     */
    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    /**
     * Convert the Sphere into a string representation
     * e.g for showing in the list
     *
     * @return String representation of the Sphere
     */
    @Override
    public String toString() {
        return String.format("Bol (radius: %d)", radius);
    }
}