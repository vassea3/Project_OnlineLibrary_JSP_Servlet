package com.biblioteca.dao.impl;

import java.io.File;

public class DeleteFile {

    public static void DeleteFile(File dirFile) {
        if (dirFile.exists()) {
            dirFile.delete();
        }
    }
}
