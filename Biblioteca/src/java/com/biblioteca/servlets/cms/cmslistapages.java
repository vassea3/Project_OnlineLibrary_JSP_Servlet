package com.biblioteca.servlets.cms;

import com.biblioteca.dao.impl.MyAboutPageImpl;
import com.biblioteca.dao.impl.MyHomePageImpl;
import com.biblioteca.dao.intf.MyAboutPageIntf;
import com.biblioteca.dao.intf.MyHomePageIntf;
import com.biblioteca.entitati.MyAboutPage;
import com.biblioteca.entitati.MyHomePage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet(name = "cmslistapages", urlPatterns = {"/cmslistapages"})
public class cmslistapages extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        if (request.getSession().getAttribute("ONLINEUSER") == null) {
            page = "/cmsshowlogin";
        } else {
            page = "/WEB-INF/cms/cmsListaPages.jsp";
            int id = 1;
            DataSource ds = (DataSource) request.getServletContext().getAttribute("dataSource");
            MyHomePageIntf homeDao = new MyHomePageImpl(ds);
            MyHomePage home = homeDao.findById(id);
            MyAboutPageIntf aboutDao = new MyAboutPageImpl(ds);
            MyAboutPage about = aboutDao.findById(id);
            File fileHome1 = new File("C:\\Users\\Taniusha\\Documents\\NetBeansProjects\\Biblioteca\\web\\resources\\images/pageImages/" + home.getSlideImg1());
            File fileHome2 = new File("C:\\Users\\Taniusha\\Documents\\NetBeansProjects\\Biblioteca\\web\\resources\\images/pageImages/" + home.getSlideImg2());
            File fileHome3 = new File("C:\\Users\\Taniusha\\Documents\\NetBeansProjects\\Biblioteca\\web\\resources\\images/pageImages/" + home.getSlideImg3());
            File fileAbout = new File("C:\\Users\\Taniusha\\Documents\\NetBeansProjects\\Biblioteca\\web\\resources\\images/pageImages/" + about.getLibImage());
            if (!fileHome1.exists()) {
                try (OutputStream outputStream = new FileOutputStream(fileHome1)) {
                    IOUtils.copy(home.getSlideImg1Bytes(), outputStream);
                }
            }
            if (!fileHome2.exists()) {
                try (OutputStream outputStream = new FileOutputStream(fileHome2)) {
                    IOUtils.copy(home.getSlideImg2Bytes(), outputStream);
                }
            }
            if (!fileHome3.exists()) {
                try (OutputStream outputStream = new FileOutputStream(fileHome3)) {
                    IOUtils.copy(home.getSlideImg3Bytes(), outputStream);
                }
            }
            if (!fileAbout.exists()) {
                try (OutputStream outputStream = new FileOutputStream(fileAbout)) {
                    IOUtils.copy(about.getLibImageBytes(), outputStream);
                }
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
