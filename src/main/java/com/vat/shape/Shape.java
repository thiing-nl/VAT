package com.vat.shape;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Shape representation
 */
public interface Shape extends Serializable {

    /**
     * This is where the type will be Stored
     */
    String getType();

    /**
     * This will calculate the volume in the Shape
     */
    double calculateVolume();

    /**
     * This will convert the Shape into text which is save-able to a file.
     */
    String toString();

    HashMap<String, String> getFields();

    HashMap<String, Integer> getData();

    void setData(HashMap<String, Integer> data);
}