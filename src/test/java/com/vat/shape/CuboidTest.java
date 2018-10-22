package com.vat.shape;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CuboidTest {

    @Test
    void getData() {
        Cuboid cuboid = new Cuboid( 88, 9, 22);

        HashMap<String, Integer> data = cuboid.getData();

        assertEquals(88, (int) data.get("length"));
        assertEquals(9, (int) data.get("width"));
        assertEquals(22, (int) data.get("height"));

    }

    @Test
    void setData() {
        Cuboid cuboid = new Cuboid( 3, 8, 13);

        assertEquals(3, cuboid.getLength());
        assertEquals(8, cuboid.getWidth());
        assertEquals(13, cuboid.getHeight());

        HashMap<String, Integer> data = new HashMap<>();

        data.put("length", 22);
        data.put("width", 34);
        data.put("height", 4);

        cuboid.setData(data);

        assertEquals(22, cuboid.getLength());
        assertEquals(34, cuboid.getWidth());
        assertEquals(4, cuboid.getHeight());
    }
}