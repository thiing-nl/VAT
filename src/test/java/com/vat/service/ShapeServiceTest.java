package com.vat.service;

import com.vat.shape.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ShapeServiceTest {

    @Test
    void calculateTotalVolume() {
        ShapeService shapeService = new ShapeService();

        Cuboid cuboid = new Cuboid(1, 2, 3);
        shapeService.addShape(cuboid);
        Cube cube = new Cube(1);
        shapeService.addShape(cube);
        Pyramid pyramid = new Pyramid(1, 2, 3);
        shapeService.addShape(pyramid);
        Cone cone = new Cone(1, 2);
        shapeService.addShape(cone);
        Cylinder cylinder = new Cylinder(1, 2);
        shapeService.addShape(cylinder);
        Sphere sphere = new Sphere(1);
        shapeService.addShape(sphere);

        System.out.println(shapeService.calculateTotalVolume());

        // What I basically did was calculated the volume from each Shape and the total sum is below.
        double totalVolume = 0.0;
        totalVolume += cuboid.calculateVolume();
        totalVolume += cube.calculateVolume();
        totalVolume += pyramid.calculateVolume();
        totalVolume += cone.calculateVolume();
        totalVolume += cylinder.calculateVolume();
        totalVolume += sphere.calculateVolume();

        assertEquals(totalVolume, shapeService.calculateTotalVolume());
    }

    @Test
    void getFields() {
        assertNull(ShapeService.getFields(""));
        assertEquals(ShapeService.getFields("Blok"), Cuboid.fields);
        assertEquals(ShapeService.getFields("Bol"), Sphere.fields);
        assertEquals(ShapeService.getFields("Cilinder"), Cylinder.fields);
        assertEquals(ShapeService.getFields("Kegel"), Cone.fields);
        assertEquals(ShapeService.getFields("Kubus"), Cube.fields);
        assertEquals(ShapeService.getFields("Piramide"), Pyramid.fields);
    }

    @Test
    void setShapes() {
        ShapeService shapeService = new ShapeService();

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Sphere(10));
        shapeService.setShapes(shapes);

        assertEquals(shapeService.getShapes(), shapes);
    }

    @Test
    void addShapeCuboid() {
        ShapeService shapeService = new ShapeService();

        HashMap<String, Integer> cuboidData = new HashMap<String, Integer>() {{
            put("length", 1);
            put("width", 2);
            put("height", 3);
        }};
        Cuboid cuboid = (Cuboid) shapeService.addShape("Blok", cuboidData);

        assertNotNull(cuboid);
        assertTrue(shapeService.getShapes().contains(cuboid));
        assertEquals(cuboid.getData(), cuboidData);
    }

    @Test
    void addShapeSphere() {
        ShapeService shapeService = new ShapeService();

        HashMap<String, Integer> sphereData = new HashMap<String, Integer>() {{
            put("radius", 1);
        }};
        Sphere sphere = (Sphere) shapeService.addShape("Bol", sphereData);

        assertNotNull(sphere);
        assertTrue(shapeService.getShapes().contains(sphere));
        assertEquals(sphere.getData(), sphereData);
    }

    @Test
    void addShapeCylinder() {
        ShapeService shapeService = new ShapeService();

        HashMap<String, Integer> cylinderData = new HashMap<String, Integer>() {{
            put("radius", 1);
            put("height", 2);
        }};
        Cylinder cylinder = (Cylinder) shapeService.addShape("Cilinder", cylinderData);

        assertNotNull(cylinder);
        assertTrue(shapeService.getShapes().contains(cylinder));
        assertEquals(cylinder.getData(), cylinderData);
    }

    @Test
    void addShapeCone() {
        ShapeService shapeService = new ShapeService();

        HashMap<String, Integer> coneData = new HashMap<String, Integer>() {{
            put("radius", 1);
            put("height", 2);
        }};
        Cone cone = (Cone) shapeService.addShape("Kegel", coneData);

        assertNotNull(cone);
        assertTrue(shapeService.getShapes().contains(cone));
        assertEquals(cone.getData(), coneData);
    }

    @Test
    void addShapeCube() {
        ShapeService shapeService = new ShapeService();

        HashMap<String, Integer> cubeData = new HashMap<String, Integer>() {{
            put("width", 1);
        }};
        Cube cube = (Cube) shapeService.addShape("Kubus", cubeData);

        assertNotNull(cube);
        assertTrue(shapeService.getShapes().contains(cube));
        assertEquals(cube.getData(), cubeData);
    }

    @Test
    void addShapePyramid() {
        ShapeService shapeService = new ShapeService();

        HashMap<String, Integer> pyramidData = new HashMap<String, Integer>() {{
            put("length", 1);
            put("width", 2);
            put("height", 3);
        }};
        Pyramid pyramid = (Pyramid) shapeService.addShape("Piramide", pyramidData);

        assertNotNull(pyramid);
        assertTrue(shapeService.getShapes().contains(pyramid));
        assertEquals(pyramid.getData(), pyramidData);
    }

    @Test
    void addShapeNull() {
        ShapeService shapeService = new ShapeService();

        assertThrows(NullPointerException.class, () -> shapeService.addShape(null, new HashMap<>()));
    }

    @Test
    void addShapeInvalid() {
        ShapeService shapeService = new ShapeService();

        assertNull(shapeService.addShape("", new HashMap<>()));
    }
}