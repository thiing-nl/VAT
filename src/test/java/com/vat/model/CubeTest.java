package com.vat.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CubeTest {

    @Test
    void getData() {
        Cube cube = new Cube(12);

        HashMap<String, Integer> data = cube.getData();

        assertEquals( 12,(int) data.get("width"));
    }

    @Test
    void setData() {
        Cube cube = new Cube(34);

        assertEquals( 34, cube.getWidth());

        HashMap<String, Integer> data = new HashMap<>();

        data.put("width", 55);

        cube.setData(data);

        assertEquals( 55, cube.getWidth());
    }

    @Test
    void calculateVolume() {
        Cube cube = new Cube(4);

        cube.calculateVolume();

        assertEquals(Math.pow(4, 3), cube.calculateVolume());
    }

    @Test
    void testToString() {
        Cube cube = new Cube(59);

        assertEquals(String.format("Kubus (breedte: %d)", 59), cube.toString());
    }
}