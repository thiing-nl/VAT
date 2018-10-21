package com.vat.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void getData() {
        Sphere sphere = new Sphere(4);

        HashMap<String, Integer> data = sphere.getData();

        assertEquals(4, (int) data.get("radius"));
    }

    @Test
    void setData() {
        Sphere sphere = new Sphere(9);

        assertEquals(9, sphere.getRadius());

        HashMap<String, Integer> data = new HashMap<>();

        data.put("radius", 12);

        sphere.setData(data);

        assertEquals(12, sphere.getRadius());
    }

    @Test
    void calculateVolume() {
        Sphere sphere = new Sphere(2);

        sphere.calculateVolume();

        assertEquals((4.0 / 3.0) * Math.PI * Math.pow(2, 3), sphere.calculateVolume());
    }

    @Test
    void testToString() {
        Sphere sphere = new Sphere(7);

        assertEquals(String.format("Bol (radius: %d)", 7), sphere.toString());
    }
}