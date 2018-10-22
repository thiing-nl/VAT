package com.vat.data;

import com.vat.shape.Shape;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StorageInterface {

    ArrayList<Shape> loadData() throws Exception;

    ArrayList<Shape> loadData(String location) throws Exception;

    void saveData(ArrayList<Shape> shapes) throws Exception;

    void saveData(String location, ArrayList<Shape> shapes) throws Exception;

}
