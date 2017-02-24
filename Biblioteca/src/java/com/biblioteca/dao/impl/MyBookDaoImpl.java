package com.biblioteca.dao.impl;

import com.biblioteca.dao.intf.MyBookDaoIntf;
import com.biblioteca.entitati.MyBook;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class MyBookDaoImpl implements MyBookDaoIntf {

    private DataSource ds;
    private Connection connection;

    public MyBookDaoImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public void save(MyBook book) {
        try {
            connection = ds.getConnection();
            MyBook aMyBook = null;
            String sql = "INSERT INTO books VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement bstat = connection.prepareStatement(sql);
            bstat.setString(1, book.getBookName());
            bstat.setString(2, book.getAuthor());
            bstat.setString(3, book.getSummary());
            bstat.setString(4, book.getFileName());
            bstat.setBinaryStream(5, book.getFileBytes());
            bstat.setString(6, book.getBookImageName());
            bstat.setBinaryStream(7, book.getBookImageBytes());
            bstat.setString(8, book.getGender());
            bstat.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MyBookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(MyBook book) {
        try {
            connection = ds.getConnection();
            MyBook aMyBook = null;
            String sql = "UPDATE books SET bookName=? , author=?, summary=?, fileName=?, fileByte=?,"
                    + "bookImageName=?,bookImageBytes=?, bookGender=? WHERE bookId=?";
            PreparedStatement bstat = connection.prepareStatement(sql);
            bstat.setString(1, book.getBookName());
            bstat.setString(2, book.getAuthor());
            bstat.setString(3, book.getSummary());
            bstat.setString(4, book.getFileName());
            bstat.setBinaryStream(5, book.getFileBytes());
            bstat.setString(6, book.getBookImageName());
            bstat.setBinaryStream(7, book.getBookImageBytes());
            bstat.setString(8, book.getGender());
            bstat.setInt(9, book.getBookId());
            bstat.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MyBookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(MyBook book) {
        try {
            connection = ds.getConnection();
            MyBook aMyBook = null;
            String sql = "DELETE FROM books WHERE bookId=?";
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setInt(1, book.getBookId());
            pstat.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MyBookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public MyBook findById(int bookId) {
        MyBook aMyBook = null;
        try {
            connection = ds.getConnection();
            String sql = "SELECT * FROM books WHERE bookId=?";
            PreparedStatement bstat = connection.prepareStatement(sql);
            bstat.setInt(1, bookId);
            ResultSet rs = bstat.executeQuery();
            if (rs.next()) {
                String bookName = rs.getString(2);
                String author = rs.getString(3);
                String gender = rs.getString(9);
                String summary = rs.getString(4);
                String fileName = rs.getString(5);
                InputStream fileBytes = rs.getBinaryStream(6);
                String bookImageName = rs.getString(7);
                InputStream bookImageBytes = rs.getBinaryStream(8);
                aMyBook = new MyBook(bookId, bookName, author, gender, summary, fileName,
                        fileBytes, bookImageName, bookImageBytes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyBookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyBookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return aMyBook;
    }

    @Override
    public List<MyBook> findAll() {
        List<MyBook> aList = new ArrayList<>();
        try {
            connection = ds.getConnection();
            MyBook aMyBook = null;
            String sql = "SELECT * FROM books";
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                int bookId = rs.getInt(1);
                String bookName = rs.getString(2);
                String author = rs.getString(3);
                String gender = rs.getString(9);
                String summary = rs.getString(4);
                String fileName = rs.getString(5);
                InputStream fileBytes = rs.getBinaryStream(6);
                String bookImageName = rs.getString(7);
                InputStream bookImageBytes = rs.getBinaryStream(8);
                aMyBook = new MyBook(bookId, bookName, author, gender, summary, fileName,
                        fileBytes, bookImageName, bookImageBytes);
                aList.add(aMyBook);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyBookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyBookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return aList;
    }

    @Override
    public List<MyBook> findByAuthor(String author) {
        List<MyBook> aList = new ArrayList<>();
        MyBook aMyBook = null;
        try {
            connection = ds.getConnection();
            String sql = "SELECT * FROM books WHERE author=?";
            PreparedStatement bstat = connection.prepareStatement(sql);
            bstat.setString(1, author);
            ResultSet rs = bstat.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt(1);
                String bookName = rs.getString(2);
                String gender = rs.getString(9);
                String summary = rs.getString(4);
                String fileName = rs.getString(5);
                InputStream fileBytes = rs.getBinaryStream(6);
                String bookImageName = rs.getString(7);
                InputStream bookImageBytes = rs.getBinaryStream(8);
                aMyBook = new MyBook(bookId, bookName, author, gender, summary, fileName,
                        fileBytes, bookImageName, bookImageBytes);
                aList.add(aMyBook);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyBookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyBookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return aList;
    }

    @Override
    public List<MyBook> findByGender(String gender) {
        List<MyBook> aList = new ArrayList<>();
        MyBook aMyBook = null;
        try {
            connection = ds.getConnection();
            String sql = "SELECT * FROM books WHERE bookGender=?";
            PreparedStatement bstat = connection.prepareStatement(sql);
            bstat.setString(1, gender);
            ResultSet rs = bstat.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt(1);
                String bookName = rs.getString(2);
                String author = rs.getString(3);
                String summary = rs.getString(4);
                String fileName = rs.getString(5);
                InputStream fileBytes = rs.getBinaryStream(6);
                String bookImageName = rs.getString(7);
                InputStream bookImageBytes = rs.getBinaryStream(8);
                aMyBook = new MyBook(bookId, bookName, author, gender, summary, fileName,
                        fileBytes, bookImageName, bookImageBytes);
                aList.add(aMyBook);
            }
            connection.close();
        } catch (SQLException ex) {

        }
        return aList;
    }

    @Override
    public List<MyBook> findByName(String bookName) {
        List<MyBook> aList = new ArrayList<>();
        MyBook aMyBook = null;
        try {
            connection = ds.getConnection();
            String sql = "SELECT * FROM books WHERE bookName=?";
            PreparedStatement bstat = connection.prepareStatement(sql);
            bstat.setString(1, bookName);
            ResultSet rs = bstat.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt(1);
                String author = rs.getString(3);
                String gender = rs.getString(9);
                String summary = rs.getString(4);
                String fileName = rs.getString(5);
                InputStream fileBytes = rs.getBinaryStream(6);
                String bookImageName = rs.getString(7);
                InputStream bookImageBytes = rs.getBinaryStream(8);
                aMyBook = new MyBook(bookId, bookName, author, gender, summary, fileName,
                        fileBytes, bookImageName, bookImageBytes);
                aList.add(aMyBook);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyBookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyBookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return aList;
    }
}
