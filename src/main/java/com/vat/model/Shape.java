package com.vat.model;

import java.util.HashMap;

/**
 * Shape representation
 */
public interface Shape {

    HashMap<String, String> fields = new HashMap<>();

    int getId();

    void setId(int id);

    /**
     * This is where the type will be Stored
     */
    String getType();

    void setType(String type);

    /**
     * This will calculate the volume in the Shape
     */
    double calculateVolume();

    /**
     * Convert the Shape to JSON String
     */
    String toJSON();

    /**
     * Save as a new Shape to the database
     */
    void saveSQL();

    /**
     * This will convert the Shape into text which is save-able to a file.
     */
    String toString();

    /**
     * This will load the Shape based on the given JSON text.
     *
     * @param jsonObject
     */
    void loadJSON(int jsonObject);

    /**
     * This will load the Shape from the given id
     *
     * @param id
     */
    void loadSQL(int id);

    /**
     * It will convert the provided text representation of this object into the given object.
     *
     * @param text
     */
    void loadString(String text);

}