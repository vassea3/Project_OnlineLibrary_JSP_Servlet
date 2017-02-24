package com.biblioteca.entitati;

import java.io.InputStream;

public class MyAboutPage {

    private int id;
    private String aboutLib;
    private String libImage;
    private InputStream libImageBytes;

    public MyAboutPage(int id, String aboutLib, String libImage, InputStream libImageBytes) {
        this.id = id;
        this.aboutLib = aboutLib;
        this.libImage = libImage;
        this.libImageBytes = libImageBytes;
    }

    public InputStream getLibImageBytes() {
        return libImageBytes;
    }

    public void setLibImageBytes(InputStream libImageBytes) {
        this.libImageBytes = libImageBytes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAboutLib() {
        return aboutLib;
    }

    public void setAboutLib(String aboutLib) {
        this.aboutLib = aboutLib;
    }

    public String getLibImage() {
        return libImage;
    }

    public void setLibImage(String libImage) {
        this.libImage = libImage;
    }

    @Override
    public String toString() {
        return "MyAboutPage{" + "id=" + id + ", aboutLib=" + aboutLib + ", libImage=" + libImage + ", libImageBytes=" + libImageBytes + '}';
    }

}
