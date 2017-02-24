package com.biblioteca.listeners;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class MyApplicationServletListener implements ServletContextListener {

    private static final Logger LOG = Logger.getLogger(MyApplicationServletListener.class.getName());

    Connection conn = null;
    DataSource dataSource = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        //DS 
        LOG.info("SE FACE DEPLOY!!!! Se creaza contextul aplicatiei!");

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");

            dataSource = (DataSource) envContext.lookup("jdbc/biblioteca");

            conn = dataSource.getConnection();
            if (conn == null) {
                throw new SQLException("NU pot obrine conexiunea din " + "jdbc/biblioteca");
            }

            LOG.info("CONXIUNEA STABILITA CU SUCCES PENTRU TESTARE");

            conn.close();
            conn = null;

            sce.getServletContext().setAttribute("dataSource", dataSource);

        } catch (NamingException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        dataSource = (DataSource) sce.getServletContext().getAttribute("dataSource");
        if (dataSource != null) {
            try {
                conn = dataSource.getConnection();
                conn.close();
                conn = null;

                sce.getServletContext().removeAttribute("dataSource");

            } catch (SQLException ex) {
                Logger.getLogger(MyApplicationServletListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        LOG.info("SE FACE UN=====DEPLOY!!!! Se distruge contextul aplicatiei!");
    }

}
