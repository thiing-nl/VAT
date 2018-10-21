package com.vat.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PyramidTest {

    @Test
    void getData() {
        Pyramid pyramid = new Pyramid( 9, 3, 2);

        HashMap<String, Integer> data = pyramid.getData();

        assertEquals(9, (int) data.get("length"));
        assertEquals(3, (int) data.get("width"));
        assertEquals(2, (int) data.get("height"));

    }

    @Test
    void setData() {
        Pyramid pyramid = new Pyramid( 5, 12, 8);

        assertEquals(5, pyramid.getLength());
        assertEquals(12, pyramid.getWidth());
        assertEquals(8, pyramid.getHeight());

        HashMap<String, Integer> data = new HashMap<>();

        data.put("length", 8);
        data.put("width", 89);
        data.put("height", 10);

        pyramid.setData(data);

        assertEquals(8, pyramid.getLength());
        assertEquals(89, pyramid.getWidth());
        assertEquals(10, pyramid.getHeight());
    }

    @Test
    void calculateVolume() {
        Pyramid pyramid = new Pyramid( 2, 10, 8);

        pyramid.calculateVolume();

        assertEquals(((10.0 * 2.0) * 8.0) / 3.0, pyramid.calculateVolume());
    }

    @Test
    void testToString() {
        Pyramid pyramid = new Pyramid( 8, 1, 9);

        assertEquals(String.format("Piramide (lengte: %d, breedte: %d, hoogte: %d)", 8, 1, 9), pyramid.toString());
    }
}