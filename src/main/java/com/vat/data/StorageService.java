package com.vat.data;

import com.vat.shape.Shape;

import java.util.ArrayList;

public class StorageService {

    /**
     * Storage Type Text
     */
    public static final String STORAGE_TYPE_TEXT = "STORAGE_TYPE_TEXT";

    /**
     * Storage Type Object
     */
    public static final String STORAGE_TYPE_OBJECT = "STORAGE_TYPE_OBJECT";

    /**
     * Storage Type SQL
     */
    public static final String STORAGE_TYPE_SQL = "STORAGE_TYPE_SQL";

    /**
     * Text Storage instance
     */
    private TextStorage textStorage = new TextStorage();

    /**
     * Object Storage instance
     */
    private ObjectStorage objectStorage = new ObjectStorage();

    /**
     * SQL Storage instance
     */
    private SQLStorage sqlStorage = new SQLStorage();

    /**
     * Receives a Storage based on the Storage Type
     *
     * @param storageType - Storage Type in string (e.g StorageService.STORAGE_TYPE_TEXT)
     * @return Storage Interface instance
     */
    public StorageInterface getStorage(String storageType) {
        switch (storageType) {
            case STORAGE_TYPE_TEXT:
                return textStorage;
            case STORAGE_TYPE_OBJECT:
                return objectStorage;
            case STORAGE_TYPE_SQL:
                return sqlStorage;
            default:
                return null;
        }
    }
}
