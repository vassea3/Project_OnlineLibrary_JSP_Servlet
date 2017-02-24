package com.biblioteca.entitati;

import java.io.InputStream;

public class MyHomePage {

    private int id;
    private String slideImg1;
    private String slideImg2;
    private String slideImg3;
    private InputStream slideImg1Bytes;
    private InputStream slideImg2Bytes;
    private InputStream slideImg3Bytes;
    private String slideText1;
    private String slideText2;
    private String slideText3;
    private String siteTitle;

    public MyHomePage(int id, String slideImg1, String slideImg2, String slideImg3, InputStream slideImg1Bytes, InputStream slideImg2Bytes, InputStream slideImg3Bytes, String slideText1, String slideText2, String slideText3, String siteTitle) {
        this.id = id;
        this.slideImg1 = slideImg1;
        this.slideImg2 = slideImg2;
        this.slideImg3 = slideImg3;
        this.slideImg1Bytes = slideImg1Bytes;
        this.slideImg2Bytes = slideImg2Bytes;
        this.slideImg3Bytes = slideImg3Bytes;
        this.slideText1 = slideText1;
        this.slideText2 = slideText2;
        this.slideText3 = slideText3;
        this.siteTitle = siteTitle;
    }

    public String getSiteTitle() {
        return siteTitle;
    }

    public void setSiteTitle(String siteTitle) {
        this.siteTitle = siteTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlideImg1() {
        return slideImg1;
    }

    public void setSlideImg1(String slideImg1) {
        this.slideImg1 = slideImg1;
    }

    public String getSlideImg2() {
        return slideImg2;
    }

    public void setSlideImg2(String slideImg2) {
        this.slideImg2 = slideImg2;
    }

    public String getSlideImg3() {
        return slideImg3;
    }

    public void setSlideImg3(String slideImg3) {
        this.slideImg3 = slideImg3;
    }

    public InputStream getSlideImg1Bytes() {
        return slideImg1Bytes;
    }

    public void setSlideImg1Bytes(InputStream slideImg1Bytes) {
        this.slideImg1Bytes = slideImg1Bytes;
    }

    public InputStream getSlideImg2Bytes() {
        return slideImg2Bytes;
    }

    public void setSlideImg2Bytes(InputStream slideImg2Bytes) {
        this.slideImg2Bytes = slideImg2Bytes;
    }

    public InputStream getSlideImg3Bytes() {
        return slideImg3Bytes;
    }

    public void setSlideImg3Bytes(InputStream slideImg3Bytes) {
        this.slideImg3Bytes = slideImg3Bytes;
    }

    public String getSlideText1() {
        return slideText1;
    }

    public void setSlideText1(String slideText1) {
        this.slideText1 = slideText1;
    }

    public String getSlideText2() {
        return slideText2;
    }

    public void setSlideText2(String slideText2) {
        this.slideText2 = slideText2;
    }

    public String getSlideText3() {
        return slideText3;
    }

    public void setSlideText3(String slideText3) {
        this.slideText3 = slideText3;
    }

    @Override
    public String toString() {
        return "MyHomePage{" + "id=" + id + ", slideImg1=" + slideImg1 + ", slideImg2=" + slideImg2 + ", slideImg3=" + slideImg3 + ", slideImg1Bytes=" + slideImg1Bytes + ", slideImg2Bytes=" + slideImg2Bytes + ", slideImg3Bytes=" + slideImg3Bytes + ", slideText1=" + slideText1 + ", slideText2=" + slideText2 + ", slideText3=" + slideText3 + ", siteTitle=" + siteTitle + '}';
    }

}
