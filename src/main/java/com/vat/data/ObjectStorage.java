package com.vat.data;

import com.vat.shape.Shape;

import java.io.*;
import java.util.ArrayList;

public class ObjectStorage implements StorageInterface {

    /**
     * Load data without a location given
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public ArrayList<Shape> loadData() {
        throw new UnsupportedOperationException();
    }

    /**
     * Loads the data for a given location and converts it into a shape list
     *
     * @param location - Location of the Object File
     * @return Shape List
     * @throws Exception
     */
    @Override
    public ArrayList<Shape> loadData(String location) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(location);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (ArrayList<Shape>) objectInputStream.readObject();
    }

    /**
     * Save object storage without location
     *
     * @param shapes - Shapes list to save
     * @throws UnsupportedOperationException
     */
    @Override
    public void saveData(ArrayList<Shape> shapes) {
        throw new UnsupportedOperationException();
    }

    /**
     * Save a Shape List to a given location
     *
     * @param location - Location to save the Object to
     * @param shapes   - Shapes to save
     * @throws Exception
     */
    @Override
    public void saveData(String location, ArrayList<Shape> shapes) throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(location));
        objectOutputStream.writeObject(shapes);
    }
}
