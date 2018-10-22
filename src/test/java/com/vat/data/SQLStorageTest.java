package com.vat.data;

import com.vat.shape.*;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SQLStorageTest {

    @Test
    void loadData() {
        ShapeService shapeService = new ShapeService();
        shapeService.addShape(new Cuboid(10, 15, 20));
        shapeService.addShape(new Cube(20));
        shapeService.addShape(new Pyramid(50, 30, 10));

        ArrayList<Shape> shapes = shapeService.getShapes();

        StorageInterface storageInterface = new StorageService()
                .getStorage(StorageService.STORAGE_TYPE_SQL);

        ArrayList<Shape> loadedShapes = new ArrayList<>();
        try {
            storageInterface.saveData(shapes);
            loadedShapes = storageInterface.loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(shapes.size(), loadedShapes.size());
        assertEquals(shapes.get(0).getData(), loadedShapes.get(0).getData());
        assertEquals(shapes.get(0).getFields(), loadedShapes.get(0).getFields());
        assertEquals(shapes.get(1).getData(), loadedShapes.get(1).getData());
        assertEquals(shapes.get(1).getFields(), loadedShapes.get(1).getFields());
        assertEquals(shapes.get(2).getData(), loadedShapes.get(2).getData());
        assertEquals(shapes.get(2).getFields(), loadedShapes.get(2).getFields());
    }

    @Test
    void saveData() {
        ShapeService shapeService = new ShapeService();
        shapeService.addShape(new Cuboid(10, 15, 20));
        shapeService.addShape(new Cube(20));
        shapeService.addShape(new Pyramid(50, 30, 10));

        ArrayList<Shape> shapes = shapeService.getShapes();

        SQLStorage storageInterface = (SQLStorage) new StorageService()
                .getStorage(StorageService.STORAGE_TYPE_SQL);

        try {
            storageInterface.saveData(shapes);

            Connection connection = storageInterface.newConnection();

            ResultSet rs = connection
                    .prepareStatement("SELECT count(*) as total FROM shapes")
                    .executeQuery();

            while (rs.next()) {
                assertEquals(shapes.size(), rs.getInt("total"));
            }

            connection.close();
        } catch (Exception err) {
            err.printStackTrace();
            fail("Should be able to save data to the database");
        }
    }
}