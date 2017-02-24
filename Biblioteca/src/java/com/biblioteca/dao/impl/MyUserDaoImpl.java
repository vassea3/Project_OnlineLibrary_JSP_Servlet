package com.biblioteca.dao.impl;

import com.biblioteca.dao.intf.MyUserDaoIntf;
import com.biblioteca.entitati.MyUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class MyUserDaoImpl implements MyUserDaoIntf {

    private final DataSource ds;
    private Connection connection;

    public MyUserDaoImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public MyUser getMyUserByNameAndPassword(String userName, String password) {
        MyUser user = null;
        try {
            connection = ds.getConnection();
            String sql = "SELECT * FROM user WHERE username=? AND password=?";
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, userName);
            pstat.setString(2, password);
            ResultSet rs = pstat.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                user = new MyUser(id, username, "ceva aiurea");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyUserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
