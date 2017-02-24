package com.biblioteca.servlets.cms;

import com.biblioteca.dao.impl.DeleteFile;
import com.biblioteca.dao.impl.FileSaveDao;
import com.biblioteca.dao.impl.MyAboutPageImpl;
import com.biblioteca.dao.intf.MyAboutPageIntf;
import com.biblioteca.entitati.MyAboutPage;
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

@WebServlet(name = "cmsEditAboutPage", urlPatterns = {"/cmsEditAboutPage"})
@MultipartConfig
public class cmsEditAboutPage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        if (request.getSession().getAttribute("ONLINEUSER") == null) {
            page = "/cmsshowlogin";
        } else {
            page = "cmslistapages";
            DataSource ds = (DataSource) request.getServletContext().getAttribute("dataSource");
            MyAboutPageIntf aboutDao = new MyAboutPageImpl(ds);
            int aboutId = 1;
            MyAboutPage aboutFromDB = aboutDao.findById(aboutId);
            String aboutLib = request.getParameter("aboutLib");
            Part filePart = request.getPart("libImage");
            String fileName = FileSaveDao.getFileName(filePart);
            InputStream fileNameByte;
            if (fileName.isEmpty()) {
                fileName = aboutFromDB.getLibImage();
                fileNameByte = aboutFromDB.getLibImageBytes();
            } else {
                File aboutImage = new File("C:\\Users\\Taniusha\\Documents\\NetBeansProjects\\Biblioteca\\web\\resources\\images/pageImages/" + aboutFromDB.getLibImage());
                DeleteFile.DeleteFile(aboutImage);
                String filePath = request.getServletContext().getRealPath("");
                fileNameByte = FileSaveDao.addFile(filePart, fileName, filePath);
            }
            if (aboutFromDB != null) {
                aboutFromDB.setAboutLib(aboutLib);
                aboutFromDB.setLibImage(fileName);
                aboutFromDB.setLibImageBytes(fileNameByte);
                aboutDao.update(aboutFromDB);
            }
            request.setAttribute("succes", "Page About was edited");
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
