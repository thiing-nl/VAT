package com.vat.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConeTest {

    @Test
    void getData() {
        Cone cone = new Cone(20, 10);

        HashMap<String, Integer> data = cone.getData();

        assertEquals(20, (int) data.get("radius"));
        assertEquals(10, (int) data.get("height"));
    }

    @Test
    void setData() {
        Cone cone = new Cone(20, 10);

        assertEquals(20, cone.getRadius());
        assertEquals(10, cone.getHeight());

        HashMap<String, Integer> data = new HashMap<>();

        data.put("radius", 30);
        data.put("height", 40);

        cone.setData(data);

        assertEquals(30, cone.getRadius());
        assertEquals(40, cone.getHeight());
    }

    @Test
    void calculateVolume() {
        Cone cone = new Cone(2, 6);

        cone.calculateVolume();

        assertEquals(((1.0 / 3.0) * Math.PI * Math.pow(2, 2) * 6), cone.calculateVolume());

    }

    @Test
    void testToString() {
        Cone cone = new Cone(5, 9);

        assertEquals(String.format("Kegel (radius: %d, hoogte: %d)", 5, 9), cone.toString());
    }
}