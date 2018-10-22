package com.vat.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StorageServiceTest {

    @Test
    void getStorageInvalidArgument() {
        StorageService storageService = new StorageService();

        assertThrows(NullPointerException.class, () -> storageService.getStorage(null));
    }

    @Test
    void getStorageInvalidStorage() {
        StorageService storageService = new StorageService();

        assertNull(storageService.getStorage(""));
    }

    @Test
    void getStorageValid() {
        StorageService storageService = new StorageService();

        assertNotNull(storageService.getStorage(StorageService.STORAGE_TYPE_TEXT));
    }
}