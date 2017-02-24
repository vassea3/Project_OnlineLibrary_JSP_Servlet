package com.biblioteca.servlets.client;

import com.biblioteca.dao.impl.MyHomePageImpl;
import com.biblioteca.dao.intf.MyHomePageIntf;
import com.biblioteca.entitati.MyHomePage;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class home extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = 1;
        DataSource ds = (DataSource) request.getServletContext().getAttribute("dataSource");
        MyHomePageIntf homeDao = new MyHomePageImpl(ds);
        MyHomePage home = homeDao.findById(id);
        request.setAttribute("home", home);
        HttpSession session = request.getSession();
        session.setAttribute("siteTitle", home.getSiteTitle());
        String page = "client/home.jsp";
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
