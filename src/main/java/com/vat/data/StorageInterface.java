package com.vat.data;

import com.vat.shape.Shape;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StorageInterface {

    /**
     * Load data from the SQL server
     *
     * @return Shape list
     * @throws Exception
     */
    ArrayList<Shape> loadData() throws Exception;

    /**
     * Loads the data with a location given
     *
     * @param location - Location we would like to receive it from
     * @return List of Shapes
     * @throws Exception
     */
    ArrayList<Shape> loadData(String location) throws Exception;

    /**
     * Saves the given list of shapes to the database
     *
     * @param shapes - List of Shapes
     * @throws Exception
     */
    void saveData(ArrayList<Shape> shapes) throws Exception;

    /**
     * Save list of shapes with given location
     * (we will ignore the location and run saveData(shapes) instead)
     *
     * @param location - Location we would like to save to
     * @param shapes   - List of Shapes
     * @throws Exception
     */
    void saveData(String location, ArrayList<Shape> shapes) throws Exception;

}
