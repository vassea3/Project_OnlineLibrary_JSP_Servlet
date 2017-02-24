package com.biblioteca.dao.impl;

import com.biblioteca.dao.intf.MyMessageFromContactIntf;
import com.biblioteca.entitati.MyMessageFromContact;
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

public class MyMessageFromContactImpl implements MyMessageFromContactIntf {

    private final DataSource ds;
    private Connection connection;

    public MyMessageFromContactImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public void save(MyMessageFromContact message) {
        try {
            connection = ds.getConnection();
            MyMessageFromContact aMyMessage = null;
            String sql = "INSERT INTO contactmessage VALUES(null, ?, ?, ?, ?)";
            PreparedStatement bstat = connection.prepareStatement(sql);
            bstat.setString(1, message.getName());
            bstat.setString(2, message.getEmail());
            bstat.setString(3, message.getSubject());
            bstat.setString(4, message.getMessage());
            bstat.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MyMessageFromContactIntf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(MyMessageFromContact message) {
        try {
            connection = ds.getConnection();
            MyMessageFromContact aMyMessageFromContact = null;
            String sql = "DELETE FROM contactmessage WHERE id=?";
            PreparedStatement mstat = connection.prepareStatement(sql);
            mstat.setInt(1, message.getId());
            mstat.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MyMessageFromContactImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public MyMessageFromContact findById(int id) {
        MyMessageFromContact aMyMessageFromContact = null;
        try {
            connection = ds.getConnection();
            String sql = "SELECT * FROM contactmessage WHERE id=?";
            PreparedStatement mstat = connection.prepareStatement(sql);
            mstat.setInt(1, id);
            ResultSet rs = mstat.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                String email = rs.getString(3);
                String subject = rs.getString(4);
                String message = rs.getString(5);
                aMyMessageFromContact = new MyMessageFromContact(id, name, email, subject, message);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyMessageFromContactImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyMessageFromContactImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return aMyMessageFromContact;
    }

    @Override
    public List<MyMessageFromContact> findAll() {
        List<MyMessageFromContact> aList = new ArrayList<>();
        try {
            connection = ds.getConnection();
            MyMessageFromContact aMyMessage = null;
            String sql = "SELECT * FROM contactmessage";
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String subject = rs.getString(4);
                String message = rs.getString(5);
                aMyMessage = new MyMessageFromContact(id, name, email, subject, message);
                aList.add(aMyMessage);
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
