package com.vat.data;

import com.vat.shape.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SQLStorage implements StorageInterface {

    private Connection connection;

    public Connection newConnection() throws Exception {
        return connect();
    }

    private static Connection connect() throws Exception {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vat?useSSL=false&serverTimezone=UTC",
                "vat",
                "$u_7h~M3dTc#*q2x4_L;oqJkc7wyx^/n"
        );
    }

    public static boolean canMakeConnection() {
        try {
            connect();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public ArrayList<Shape> loadData() throws Exception {
        this.connection = connect();

        Statement statement = connection.createStatement();

        ResultSet shapesResultSet = statement.executeQuery("SELECT * FROM shapes");

        ArrayList<Shape> shapes = new ArrayList<>();

        while (shapesResultSet.next()) {
            String shapeType = shapesResultSet.getString("type");

            int radius = shapesResultSet.getInt("radius");
            int length = shapesResultSet.getInt("length");
            int width = shapesResultSet.getInt("width");
            int height = shapesResultSet.getInt("height");

            switch (shapeType) {
                case "Cone":
                    shapes.add(new Cone(radius, height));
                    break;
                case "Cube":
                    shapes.add(new Cube(width));
                    break;
                case "Cuboid":
                    shapes.add(new Cuboid(length, width, height));
                    break;
                case "Cylinder":
                    shapes.add(new Cylinder(radius, height));
                    break;
                case "Pyramid":
                    shapes.add(new Pyramid(length, width, height));
                    break;
                case "Sphere":
                    shapes.add(new Sphere(radius));
                    break;
            }
        }

        // After receiving shapes we close the connection
        connection.close();

        return shapes;
    }

    private void saveShape(Shape shape) throws Exception {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO shapes (type, length, width, height, radius) VALUES (?, ?, ?, ?, ?)");

        HashMap<String, Integer> data = shape.getData();

        statement.setObject(1, shape.getType());
        statement.setObject(2, data.getOrDefault("length", null));
        statement.setObject(3, data.getOrDefault("width", null));
        statement.setObject(4, data.getOrDefault("height", null));
        statement.setObject(5, data.getOrDefault("radius", null));

        statement.executeUpdate();
    }

    @Override
    public ArrayList<Shape> loadData(String location) throws Exception {
        return this.loadData();
    }

    @Override
    public void saveData(ArrayList<Shape> shapes) throws Exception {
        this.connection = connect();

        connection.prepareStatement("DELETE FROM shapes")
                .execute();

        for (Shape shape : shapes) {
            this.saveShape(shape);
        }

        connection.close();
    }

    @Override
    public void saveData(String location, ArrayList<Shape> shapes) throws Exception {
        this.saveData(shapes);
    }
}
