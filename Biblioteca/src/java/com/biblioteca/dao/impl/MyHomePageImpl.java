package com.biblioteca.dao.impl;

import com.biblioteca.dao.intf.MyHomePageIntf;
import com.biblioteca.entitati.MyHomePage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class MyHomePageImpl implements MyHomePageIntf {

    private final DataSource ds;
    private Connection connection;

    public MyHomePageImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public void update(MyHomePage home) {
        try {
            connection = ds.getConnection();
            String sql = "UPDATE homepage SET slideImg1=? , slideImg2=? ,slideImg3=? , slideText1=?,"
                    + " slideText2=?, slideText3=?, siteTitle=?, slideImg1Bytes=?,slideImg2Bytes=?,"
                    + " slideImg3Bytes=? WHERE id=?";
            PreparedStatement hstat = connection.prepareStatement(sql);
            hstat.setString(1, home.getSlideImg1());
            hstat.setString(2, home.getSlideImg2());
            hstat.setString(3, home.getSlideImg3());
            hstat.setString(4, home.getSlideText1());
            hstat.setString(5, home.getSlideText2());
            hstat.setString(6, home.getSlideText3());
            hstat.setString(7, home.getSiteTitle());
            hstat.setBinaryStream(8, home.getSlideImg1Bytes());
            hstat.setBinaryStream(9, home.getSlideImg2Bytes());
            hstat.setBinaryStream(10, home.getSlideImg3Bytes());
            hstat.setInt(11, home.getId());
            hstat.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MyHomePageImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public MyHomePage findById(int id) {
        MyHomePage aMyHomePage = null;
        try {
            connection = ds.getConnection();
            String sql = "SELECT * FROM homepage WHERE id=?";
            PreparedStatement hstat = connection.prepareStatement(sql);
            hstat.setInt(1, id);
            ResultSet rs = hstat.executeQuery();
            if (rs.next()) {
                String slideImg1 = rs.getString(2);
                String slideImg2 = rs.getString(3);
                String slideImg3 = rs.getString(4);
                InputStream slideImg1Bytes = rs.getBinaryStream(5);
                InputStream slideImg2Bytes = rs.getBinaryStream(6);
                InputStream slideImg3Bytes = rs.getBinaryStream(7);
                String slideText1 = rs.getString(8);
                String slideText2 = rs.getString(9);
                String slideText3 = rs.getString(10);
                String siteTitle = rs.getString(11);
                aMyHomePage = new MyHomePage(id, slideImg1, slideImg2, slideImg3, slideImg1Bytes, slideImg2Bytes,
                        slideImg3Bytes, slideText1, slideText2, slideText3, siteTitle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyHomePageImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyHomePageImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return aMyHomePage;
    }
}
