package com.biblioteca.dao.impl;

import com.biblioteca.dao.intf.MyContactPageIntf;
import com.biblioteca.entitati.MyContactPage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class MyContactPageImpl implements MyContactPageIntf {

    private final DataSource ds;
    private Connection connection;

    public MyContactPageImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public void update(MyContactPage contact) {
        try {
            connection = ds.getConnection();
            String sql = "UPDATE contactpage SET city=? , street=? ,phone=? , email=?,"
                    + " graphic=?  WHERE ID=?";
            PreparedStatement cstat = connection.prepareStatement(sql);
            cstat.setString(1, contact.getCity());
            cstat.setString(2, contact.getStreet());
            cstat.setString(3, contact.getPhone());
            cstat.setString(4, contact.getEmail());
            cstat.setString(5, contact.getGraphic());
            cstat.setInt(6, contact.getId());
            cstat.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MyContactPageImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public MyContactPage findById(int id) {
        MyContactPage aMyContactPage = null;
        try {
            connection = ds.getConnection();
            String sql = "SELECT * FROM contactpage WHERE id=?";
            PreparedStatement cstat = connection.prepareStatement(sql);
            cstat.setInt(1, id);
            ResultSet rs = cstat.executeQuery();
            if (rs.next()) {
                String city = rs.getString(2);
                String street = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                String graphic = rs.getString(6);
                aMyContactPage = new MyContactPage(id, city, street, phone, email, graphic);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyContactPageImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyContactPageImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return aMyContactPage;
    }
}
