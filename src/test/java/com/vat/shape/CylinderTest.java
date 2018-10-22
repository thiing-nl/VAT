package com.vat.shape;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    @Test
    void getData() {
        Cylinder cylinder = new Cylinder( 12, 90);

        HashMap<String, Integer> data = cylinder.getData();

        assertEquals(12, (int) data.get("radius"));
        assertEquals(90, (int) data.get("height"));
    }

    @Test
    void setData() {
        Cylinder cylinder = new Cylinder( 8, 12);

        assertEquals(8, cylinder.getRadius());
        assertEquals(12, cylinder.getHeight());

        HashMap<String, Integer> data = new HashMap<>();

        data.put("radius", 34);
        data.put("height", 90);

        cylinder.setData(data);

        assertEquals(34, cylinder.getRadius());
        assertEquals(90, cylinder.getHeight());
    }
}