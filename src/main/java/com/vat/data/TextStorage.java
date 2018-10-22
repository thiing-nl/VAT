package com.vat.data;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.sun.codemodel.internal.JArray;
import com.vat.shape.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;

public class TextStorage implements StorageInterface {

    /**
     * Shape List Type
     */
    private Type shapeList = new TypeToken<ArrayList<Shape>>() {
    }.getType();

    /**
     * Deserializer for the JSON file
     */
    private JsonDeserializer<ArrayList<Shape>> deserializer = (json, typeOfT, context) -> {
        ArrayList<Shape> shapes = new ArrayList<>();
        JsonArray jsonArray = (JsonArray) json;

        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            switch (jsonObject.get("type").getAsString()) {
                case "Cone":
                    shapes.add(new Cone(jsonObject.get("radius").getAsInt(), jsonObject.get("height").getAsInt()));
                    break;
                case "Cube":
                    shapes.add(new Cube(jsonObject.get("width").getAsInt()));
                    break;
                case "Cuboid":
                    shapes.add(new Cuboid(jsonObject.get("length").getAsInt(), jsonObject.get("width").getAsInt(), jsonObject.get("height").getAsInt()));
                    break;
                case "Cylinder":
                    shapes.add(new Cylinder(jsonObject.get("radius").getAsInt(), jsonObject.get("height").getAsInt()));
                    break;
                case "Pyramid":
                    shapes.add(new Pyramid(jsonObject.get("length").getAsInt(), jsonObject.get("width").getAsInt(), jsonObject.get("height").getAsInt()));
                    break;
                case "Sphere":
                    shapes.add(new Sphere(jsonObject.get("radius").getAsInt()));
                    break;
            }
        }

        return shapes;
    };

    /**
     * Load data without a location given
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public ArrayList<Shape> loadData() {
        throw new UnsupportedOperationException();
    }

    /**
     * Loads the data for a given location and converts it into a shape list
     *
     * @param location - Location of the Text File
     * @return Shape List
     * @throws Exception
     */
    @Override
    public ArrayList<Shape> loadData(String location) throws Exception {
        FileReader fileReader = new FileReader(location);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder file = new StringBuilder();

        String currentLine = bufferedReader.readLine();

        while (currentLine != null) {
            file.append(currentLine);
            file.append(System.lineSeparator());
            currentLine = bufferedReader.readLine();
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(shapeList, this.deserializer);
        Gson customGson = gsonBuilder.create();

        return customGson.fromJson(file.toString(), shapeList);
    }

    /**
     * Save text storage without location
     *
     * @param shapes - Shapes list to save
     * @throws UnsupportedOperationException
     */
    @Override
    public void saveData(ArrayList<Shape> shapes) {
        throw new UnsupportedOperationException();
    }

    /**
     * Save a Shape List to a given location
     *
     * @param location - Location to save the Text to
     * @param shapes   - Shapes to save
     * @throws Exception
     */
    @Override
    public void saveData(String location, ArrayList<Shape> shapes) throws Exception {
        String json = new Gson().toJson(shapes);
        FileWriter fileWriter = new FileWriter(location);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(json);
        bufferedWriter.close();
    }
}
