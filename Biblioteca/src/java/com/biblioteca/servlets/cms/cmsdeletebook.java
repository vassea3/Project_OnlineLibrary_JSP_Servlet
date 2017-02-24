package com.biblioteca.servlets.cms;

import com.biblioteca.dao.impl.DeleteFile;
import com.biblioteca.dao.impl.MyBookDaoImpl;
import com.biblioteca.dao.intf.MyBookDaoIntf;
import com.biblioteca.entitati.MyBook;
import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "cmsdeletebook", urlPatterns = {"/cmsdeletebook"})
public class cmsdeletebook extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        if (request.getSession().getAttribute("ONLINEUSER") == null) {
            page = "/cmsshowlogin";
        } else {
            page = "cmslistabooks";
            DataSource ds = (DataSource) request.getServletContext().getAttribute("dataSource");
            MyBookDaoIntf bookDao = new MyBookDaoImpl(ds);
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            MyBook book = bookDao.findById(bookId);
            if (book != null) {
                File imageFile = new File("C:\\Users\\Taniusha\\Documents\\NetBeansProjects\\Biblioteca\\web\\resources\\images/" + book.getBookImageName());
                DeleteFile.DeleteFile(imageFile);
                File bookFile = new File("C:\\Users\\Taniusha\\Documents\\NetBeansProjects\\Biblioteca\\web\\resources\\bookFiles/" + book.getFileName());
                DeleteFile.DeleteFile(bookFile);
                bookDao.delete(book);
            }
            request.setAttribute("bookName", book.getBookName() + " was deleted");
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
