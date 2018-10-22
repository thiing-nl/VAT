package com.vat.data;

import com.vat.shape.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SQLStorage implements StorageInterface {

    /**
     * Database URL we will access
     */
    private static String databaseUrl = "jdbc:mysql://localhost:3306/vat?useSSL=false&serverTimezone=UTC";

    /**
     * Active connection to the database.
     */
    private Connection connection;

    /**
     * Get the current database url
     *
     * @return Current database url
     */
    static String getDatabaseUrl() {
        return databaseUrl;
    }

    /**
     * Setter for the Database Url
     *
     * @param databaseUrl - New Database Url
     */
    static void setDatabaseUrl(String databaseUrl) {
        SQLStorage.databaseUrl = databaseUrl;
    }

    /**
     * Connect to the current databaseUrl with username and password
     *
     * @return Returns the Connection
     * @throws Exception
     */
    private static Connection connect() throws Exception {
        return DriverManager.getConnection(
                databaseUrl,
                "vat",
                "$u_7h~M3dTc#*q2x4_L;oqJkc7wyx^/n"
        );
    }

    /**
     * Check whether or not we can connect to the database without problems
     *
     * @return State
     */
    public static boolean canMakeConnection() {
        try {
            connect();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * Create a new Connection to the database
     *
     * @return New Connection
     * @throws Exception
     */
    Connection newConnection() throws Exception {
        return connect();
    }

    /**
     * Load data from the SQL server
     *
     * @return Shape list
     * @throws Exception
     */
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

    /**
     * Saves a single Shape to the database
     *
     * @param shape - Shape to save
     * @throws Exception
     */
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

    /**
     * Loads the data with a location given
     * (we will ignore the location and run loadData instead)
     *
     * @param location - Location we would like to connect to
     * @return List of Shapes
     * @throws Exception
     */
    @Override
    public ArrayList<Shape> loadData(String location) throws Exception {
        return this.loadData();
    }

    /**
     * Saves the given list of shapes to the database
     *
     * @param shapes - List of Shapes
     * @throws Exception
     */
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

    /**
     * Save list of shapes with given location
     * (we will ignore the location and run saveData(shapes) instead)
     *
     * @param location - Location we would like to save to
     * @param shapes   - List of Shapes
     * @throws Exception
     */
    @Override
    public void saveData(String location, ArrayList<Shape> shapes) throws Exception {
        this.saveData(shapes);
    }
}
