package com.biblioteca.servlets.client;

import com.biblioteca.dao.impl.MyBookDaoImpl;
import com.biblioteca.dao.intf.MyBookDaoIntf;
import com.biblioteca.entitati.MyBook;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class serch extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bookNameStr = request.getParameter("bookName");
        String page = "aaa";
        DataSource ds = (DataSource) request.getServletContext().getAttribute("dataSource");
        MyBookDaoIntf booksDao = new MyBookDaoImpl(ds);
        List<MyBook> listaBookName = booksDao.findByName(bookNameStr);
        List<MyBook> listaBooks = booksDao.findByAuthor(bookNameStr);;
        if (!listaBookName.isEmpty()) {
            page = "client/books.jsp";
            request.setAttribute("listaBooks", listaBookName);
            request.setAttribute("bookNameStr", "Search resoult");

        } else if (!listaBooks.isEmpty()) {
            request.setAttribute("listaBooks", listaBooks);
            page = "client/books.jsp";
            request.setAttribute("bookNameStr", "All book of " + bookNameStr + " author");
        } else {
            request.setAttribute("bookNameStr", "We don't have books of " + bookNameStr + " author or with " + bookNameStr + " name");
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
