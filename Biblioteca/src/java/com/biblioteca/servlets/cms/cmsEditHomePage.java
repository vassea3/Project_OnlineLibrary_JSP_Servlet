package com.biblioteca.servlets.cms;

import com.biblioteca.dao.impl.DeleteFile;
import com.biblioteca.dao.impl.FileSaveDao;
import com.biblioteca.dao.impl.MyHomePageImpl;
import com.biblioteca.dao.intf.MyHomePageIntf;
import com.biblioteca.entitati.MyHomePage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

@WebServlet(name = "cmsEditHomePage", urlPatterns = {"/cmsEditHomePage"})
@MultipartConfig
public class cmsEditHomePage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        if (request.getSession().getAttribute("ONLINEUSER") == null) {
            page = "/cmsshowlogin";
        } else {
            page = "cmslistapages";
            DataSource ds = (DataSource) request.getServletContext().getAttribute("dataSource");
            MyHomePageIntf homeDao = new MyHomePageImpl(ds);
            int homeId = 1;
            String siteTitle = request.getParameter("siteTitle");
            String slideText1 = request.getParameter("slideText1");
            String slideText2 = request.getParameter("slideText2");
            String slideText3 = request.getParameter("slideText3");
            MyHomePage homeFromDB = homeDao.findById(homeId);
            Part imageByte1 = request.getPart("slideImg1");
            String slideImg1 = FileSaveDao.getFileName(imageByte1);
            InputStream img1Bytes;
            if (slideImg1.isEmpty()) {
                slideImg1 = homeFromDB.getSlideImg1();
                img1Bytes = homeFromDB.getSlideImg1Bytes();
            } else {
                File homeSlideImage1 = new File("C:\\Users\\Taniusha\\Documents\\NetBeansProjects\\Biblioteca\\web\\resources\\images/pageImages/" + homeFromDB.getSlideImg1());
                DeleteFile.DeleteFile(homeSlideImage1);
                String pathImg1 = request.getServletContext().getRealPath("");
                img1Bytes = FileSaveDao.addFile(imageByte1, slideImg1, pathImg1);
            }
            Part imageByte2 = request.getPart("slideImg2");
            String slideImg2 = FileSaveDao.getFileName(imageByte2);
            InputStream img2Bytes;
            if (slideImg2.isEmpty()) {
                slideImg2 = homeFromDB.getSlideImg2();
                img2Bytes = homeFromDB.getSlideImg2Bytes();
            } else {
                File homeSlideImage2 = new File("C:\\Users\\Taniusha\\Documents\\NetBeansProjects\\Biblioteca\\web\\resources\\images/pageImages/" + homeFromDB.getSlideImg2());
                DeleteFile.DeleteFile(homeSlideImage2);
                String pathImg2 = request.getServletContext().getRealPath("");
                img2Bytes = FileSaveDao.addFile(imageByte2, slideImg2, pathImg2);
            }
            Part imageByte3 = request.getPart("slideImg3");
            String slideImg3 = FileSaveDao.getFileName(imageByte3);
            InputStream img3Bytes;
            if (slideImg3.isEmpty()) {
                slideImg3 = homeFromDB.getSlideImg3();
                img3Bytes = homeFromDB.getSlideImg3Bytes();
            } else {
                File homeSlideImage3 = new File("C:\\Users\\Taniusha\\Documents\\NetBeansProjects\\Biblioteca\\web\\resources\\images/pageImages/" + homeFromDB.getSlideImg3());
                DeleteFile.DeleteFile(homeSlideImage3);
                String pathImg3 = request.getServletContext().getRealPath("");
                img3Bytes = FileSaveDao.addFile(imageByte3, slideImg3, pathImg3);
            }
            if (homeFromDB != null) {
                homeFromDB.setSiteTitle(siteTitle);
                homeFromDB.setSlideText1(slideText1);
                homeFromDB.setSlideText2(slideText2);
                homeFromDB.setSlideText3(slideText3);
                homeFromDB.setSlideImg1(slideImg1);
                homeFromDB.setSlideImg2(slideImg2);
                homeFromDB.setSlideImg3(slideImg3);
                homeFromDB.setSlideImg1Bytes(img1Bytes);
                homeFromDB.setSlideImg2Bytes(img2Bytes);
                homeFromDB.setSlideImg3Bytes(img3Bytes);
                homeDao.update(homeFromDB);
            }
            request.setAttribute("succes", "Page Home was edited");
        }
         RequestDispatcher rd= request.getRequestDispatcher(page);
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
