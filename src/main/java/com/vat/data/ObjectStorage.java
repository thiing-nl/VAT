package com.vat.data;

import com.vat.shape.Shape;

import java.io.*;
import java.util.ArrayList;

public class ObjectStorage implements StorageInterface {

    @Override
    public ArrayList<Shape> loadData() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ArrayList<Shape> loadData(String location) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(location);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (ArrayList<Shape>) objectInputStream.readObject();
    }

    @Override
    public void saveData(ArrayList<Shape> shapes) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void saveData(String location, ArrayList<Shape> shapes) throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(location));
        objectOutputStream.writeObject(shapes);
    }
}
