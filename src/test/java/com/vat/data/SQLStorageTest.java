package com.vat.data;

import com.vat.shape.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SQLStorageTest {

    private static String originalDatabaseUrl;

    @BeforeAll
    static void beforeAll() {
        originalDatabaseUrl = String.format("%s", SQLStorage.getDatabaseUrl());
    }

    @Test
    void loadData() {
        ShapeService shapeService = new ShapeService();
        shapeService.addShape(new Cuboid(10, 15, 20));
        shapeService.addShape(new Cube(20));
        shapeService.addShape(new Pyramid(50, 30, 10));
        shapeService.addShape(new Cone(50, 30));
        shapeService.addShape(new Cylinder(50, 30));
        shapeService.addShape(new Sphere(20));

        ArrayList<Shape> shapes = shapeService.getShapes();

        SQLStorage storageInterface = (SQLStorage) new StorageService()
                .getStorage(StorageService.STORAGE_TYPE_SQL);

        ArrayList<Shape> loadedShapes = new ArrayList<>();
        try {
            storageInterface.saveData(null, shapes);
            loadedShapes = storageInterface.loadData(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(shapes.size(), loadedShapes.size());

        for (int i = 0; i < shapes.size(); i++) {
            assertEquals(shapes.get(i).getData(), loadedShapes.get(i).getData());
            assertEquals(shapes.get(i).getFields(), loadedShapes.get(i).getFields());
        }
    }

    @Test
    void saveData() {
        ShapeService shapeService = new ShapeService();
        shapeService.addShape(new Cuboid(10, 15, 20));
        shapeService.addShape(new Cube(20));
        shapeService.addShape(new Pyramid(50, 30, 10));
        shapeService.addShape(new Cone(50, 30));
        shapeService.addShape(new Cylinder(50, 30));
        shapeService.addShape(new Sphere(20));

        ArrayList<Shape> shapes = shapeService.getShapes();

        SQLStorage storageInterface = (SQLStorage) new StorageService()
                .getStorage(StorageService.STORAGE_TYPE_SQL);

        try {
            storageInterface.saveData(null, shapes);

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

    @Test
    void canMakeConnection() {
        assertTrue(SQLStorage.canMakeConnection());
    }

    @Test
    void canMakeConnectionInvalid() {
        SQLStorage.setDatabaseUrl("jdbc:mysql://localhost:5000/vat?useSSL=false&serverTimezone=UTC");
        assertFalse(SQLStorage::canMakeConnection);
    }

    @AfterEach
    void afterEach() {
        SQLStorage.setDatabaseUrl(originalDatabaseUrl);
    }
}