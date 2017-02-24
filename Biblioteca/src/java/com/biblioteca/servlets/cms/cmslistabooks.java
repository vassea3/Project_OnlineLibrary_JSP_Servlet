package com.biblioteca.servlets.cms;

import com.biblioteca.dao.impl.MyBookDaoImpl;
import com.biblioteca.dao.intf.MyBookDaoIntf;
import com.biblioteca.entitati.MyBook;
import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet(name = "cmsbookslist", urlPatterns = {"/cmslistabooks"})
public class cmslistabooks extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page = null;
        if (request.getSession().getAttribute("ONLINEUSER") == null) {
            page = "/cmsshowlogin";
        } else {
            page = "WEB-INF/cms/cmsListaBooks.jsp";

            DataSource ds = (DataSource) request.getServletContext().getAttribute("dataSource");
            MyBookDaoIntf booksDao = new MyBookDaoImpl(ds);
            List<MyBook> listaBooks = booksDao.findAll();
            Set<String> listaGenre = new HashSet<>();
            HttpSession session = request.getSession();
            listaBooks.forEach((listaBook) -> {
                listaGenre.add(listaBook.getGender());
            });
            for (MyBook listaBook : listaBooks) {
                File file = new File("C:\\Users\\Taniusha\\Documents\\NetBeansProjects\\Biblioteca\\web\\resources\\bookFiles/" + listaBook.getFileName());
                if (!file.exists()) {
                    try (OutputStream outputStream = new FileOutputStream(file)) {
                        IOUtils.copy(listaBook.getFileBytes(), outputStream);
                    }
                }
            }
            for (MyBook listaBook : listaBooks) {
                File file = new File("C:\\Users\\Taniusha\\Documents\\NetBeansProjects\\Biblioteca\\web\\resources\\images/bookImages/" + listaBook.getBookImageName());
                if (!file.exists()) {
                    try (OutputStream outputStream = new FileOutputStream(file)) {
                        IOUtils.copy(listaBook.getBookImageBytes(), outputStream);
                    }
                }
            }
            session.setAttribute("listaGenre", listaGenre);
            request.setAttribute("listaBooks", listaBooks);
            request.setAttribute("bookNameStr", "All Books");
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
