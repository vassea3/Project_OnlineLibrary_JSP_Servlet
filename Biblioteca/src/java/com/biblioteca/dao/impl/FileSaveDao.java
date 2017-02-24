package com.biblioteca.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.servlet.http.Part;

public class FileSaveDao {

    public static InputStream addFile(Part filePart, String fileNameBytes, String filePath) throws IOException {
        InputStream filecontent = null;
        byte[] fileData;
        InputStream file = null;
        ArrayList<Byte> data = new ArrayList<>();
        try (FileOutputStream fos = new FileOutputStream(filePath + fileNameBytes);
                FileInputStream fis = new FileInputStream(filePath + fileNameBytes);) {
            filecontent = filePart.getInputStream();
            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1) {
                fos.write(bytes, 0, read);
            }
            fos.close();
            fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();
        }
        file = new ByteArrayInputStream(fileData);
        return file;
    }

    public static String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
