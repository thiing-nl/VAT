package com.vat.data;

import com.vat.shape.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TextStorageTest extends DataTestBase {

    @AfterEach
    void tearDown() {
        removeCreatedFiles();
    }

    @Test
    void loadData() {
        ShapeService shapeService = new ShapeService();
        shapeService.addShape(new Cuboid(10, 15, 20));
        shapeService.addShape(new Cube(20));
        shapeService.addShape(new Pyramid(50, 30, 10));

        ArrayList<Shape> shapes = shapeService.getShapes();

        String fileLocation = generateFileLocation("Text", "json");

        StorageInterface storageInterface = new StorageService()
                .getStorage(StorageService.STORAGE_TYPE_TEXT);

        ArrayList<Shape> loadedShapes = new ArrayList<>();
        try {
            storageInterface.saveData(fileLocation, shapeService.getShapes());
            loadedShapes = storageInterface.loadData(fileLocation);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof FileNotFoundException) {
                fail("Could not find file location");
            } else {
                fail("Unknown problem while trying to load/save the Shapes using Text Storage");
            }
        }

        assertEquals(shapes.size(), loadedShapes.size());
        assertEquals(shapes.get(0).getData(), loadedShapes.get(0).getData());
        assertEquals(shapes.get(0).getFields(), loadedShapes.get(0).getFields());
        assertEquals(shapes.get(1).getData(), loadedShapes.get(1).getData());
        assertEquals(shapes.get(1).getFields(), loadedShapes.get(1).getFields());
        assertEquals(shapes.get(2).getData(), loadedShapes.get(2).getData());
        assertEquals(shapes.get(2).getFields(), loadedShapes.get(2).getFields());

        createdFiles.add(fileLocation);
    }

    @Test
    void saveData() {
        ShapeService shapeService = new ShapeService();
        shapeService.addShape(new Cuboid(10, 15, 20));
        shapeService.addShape(new Cube(20));
        shapeService.addShape(new Pyramid(50, 30, 10));

        String fileLocation = generateFileLocation("Text", "json");

        StorageInterface storageInterface = new StorageService()
                .getStorage(StorageService.STORAGE_TYPE_TEXT);

        try {
            storageInterface.saveData(fileLocation, shapeService.getShapes());
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof FileNotFoundException) {
                fail("Could not find file location");
            } else {
                fail("Unknown problem while trying to save the Shapes using Text Storage");
            }
        }

        File file = new File(fileLocation);

        assertTrue(file.exists());

        createdFiles.add(fileLocation);
    }
}