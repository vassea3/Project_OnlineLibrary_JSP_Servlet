package com.biblioteca.dao.impl;

import com.biblioteca.dao.intf.MyAboutPageIntf;
import com.biblioteca.entitati.MyAboutPage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class MyAboutPageImpl implements MyAboutPageIntf {

    private final DataSource ds;
    private Connection connection;

    public MyAboutPageImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public void update(MyAboutPage about) {
        try {
            connection = ds.getConnection();
            String sql = "UPDATE aboutpage SET  aboutLib=?, libImage=?, libImageBytes=? WHERE id=?";
            PreparedStatement astat = connection.prepareStatement(sql);
            astat.setString(1, about.getAboutLib());
            astat.setString(2, about.getLibImage());
            astat.setBinaryStream(3, about.getLibImageBytes());
            astat.setInt(4, about.getId());
            astat.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MyAboutPageImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public MyAboutPage findById(int id) {
        MyAboutPage aMyAboutPage = null;
        try {
            connection = ds.getConnection();
            String sql = "SELECT * FROM aboutpage WHERE id=?";
            PreparedStatement bstat = connection.prepareStatement(sql);
            bstat.setInt(1, id);
            ResultSet rs = bstat.executeQuery();
            if (rs.next()) {
                String aboutLib = rs.getString(2);
                String libImage = rs.getString(3);
                InputStream libImageBytes = rs.getBinaryStream(4);
                aMyAboutPage = new MyAboutPage(id, aboutLib, libImage, libImageBytes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyAboutPageImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyAboutPageImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return aMyAboutPage;
    }
}
