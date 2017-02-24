package com.biblioteca.entitati;

import java.io.InputStream;

public class MyBook {

    private int bookId;
    private String bookName;
    private String author;
    private String gender;
    private String summary;
    private String fileName;
    private InputStream fileBytes;
    private String bookImageName;
    private InputStream bookImageBytes;

    public MyBook(int bookId, String bookName, String author, String gender, String summary, String fileName, String bookImageName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.gender = gender;
        this.summary = summary;
        this.fileName = fileName;
        this.bookImageName = bookImageName;
    }

    public MyBook(int bookId, String bookName, String author, String gender, String summary, String fileName, InputStream fileBytes, String bookImageName, InputStream bookImageBytes) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.gender = gender;
        this.summary = summary;
        this.fileName = fileName;
        this.fileBytes = fileBytes;
        this.bookImageName = bookImageName;
        this.bookImageBytes = bookImageBytes;
    }

    public MyBook(InputStream fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(InputStream fileBytes) {
        this.fileBytes = fileBytes;
    }

    public String getBookImageName() {
        return bookImageName;
    }

    public void setBookImageName(String bookImageName) {
        this.bookImageName = bookImageName;
    }

    public InputStream getBookImageBytes() {
        return bookImageBytes;
    }

    public void setBookImageBytes(InputStream bookImageBytes) {
        this.bookImageBytes = bookImageBytes;
    }

    @Override
    public String toString() {
        return "MyBook{" + "bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", gender=" + gender + ", summary=" + summary + ", fileName=" + fileName + ", fileBytes=" + fileBytes + ", bookImageName=" + bookImageName + ", bookImageBytes=" + bookImageBytes + '}';
    }
}
