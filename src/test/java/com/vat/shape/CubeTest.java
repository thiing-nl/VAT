package com.vat.shape;

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
}