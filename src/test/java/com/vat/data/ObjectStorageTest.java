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

class ObjectStorageTest extends DataTestBase {


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
        shapeService.addShape(new Cone(50, 30));
        shapeService.addShape(new Cylinder(50, 30));
        shapeService.addShape(new Sphere(20));

        ArrayList<Shape> shapes = shapeService.getShapes();

        String fileLocation = generateFileLocation("Object", "vat");

        StorageInterface storageInterface = new StorageService()
                .getStorage(StorageService.STORAGE_TYPE_OBJECT);

        ArrayList<Shape> loadedShapes = new ArrayList<>();
        try {
            storageInterface.saveData(fileLocation, shapeService.getShapes());
            loadedShapes = storageInterface.loadData(fileLocation);
        } catch (Exception e) {
            if(e instanceof FileNotFoundException) {
                fail("Could not find file location");
            } else {
                fail("Unknown problem while trying to load/save the Shapes using Object Storage");
            }
            e.printStackTrace();
        }

        assertEquals(shapes.size(), loadedShapes.size());

        for (int i = 0; i < shapes.size(); i++) {
            assertEquals(shapes.get(i).getData(), loadedShapes.get(i).getData());
            assertEquals(shapes.get(i).getFields(), loadedShapes.get(i).getFields());
        }

        createdFiles.add(fileLocation);
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

        String fileLocation = generateFileLocation("Object", "vat");

        StorageInterface storageInterface = new StorageService()
                .getStorage(StorageService.STORAGE_TYPE_OBJECT);

        try {
            storageInterface.saveData(fileLocation, shapeService.getShapes());
        } catch (Exception e) {
            if(e instanceof FileNotFoundException) {
                fail("Could not find file location");
            } else {
                fail("Unknown problem while trying to save the Shapes using Object Storage");
            }
            e.printStackTrace();
        }

        File file = new File(fileLocation);

        assertTrue(file.exists());

        createdFiles.add(fileLocation);
    }

    @Test
    void loadData1() {
        ObjectStorage objectStorage = (ObjectStorage) new StorageService()
                .getStorage(StorageService.STORAGE_TYPE_OBJECT);

        assertThrows(UnsupportedOperationException.class, objectStorage::loadData);
    }

    @Test
    void saveData1() {
        ObjectStorage objectStorage = (ObjectStorage) new StorageService()
                .getStorage(StorageService.STORAGE_TYPE_OBJECT);

        assertThrows(UnsupportedOperationException.class, () -> objectStorage.saveData(new ArrayList<>()));
    }
}