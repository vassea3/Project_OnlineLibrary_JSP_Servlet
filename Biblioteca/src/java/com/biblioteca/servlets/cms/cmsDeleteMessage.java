package com.biblioteca.servlets.cms;

import com.biblioteca.dao.impl.MyMessageFromContactImpl;
import com.biblioteca.dao.intf.MyMessageFromContactIntf;
import com.biblioteca.entitati.MyMessageFromContact;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "cmsDeleteMessage", urlPatterns = {"/cmsDeleteMessage"})
public class cmsDeleteMessage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        if (request.getSession().getAttribute("ONLINEUSER") == null) {
            page = "/cmsshowlogin";
        } else {
            page = "cmsShowMessages";
            DataSource ds = (DataSource) request.getServletContext().getAttribute("dataSource");
            MyMessageFromContactIntf messageDao = new MyMessageFromContactImpl(ds);
            int messageId = Integer.parseInt(request.getParameter("messageId"));
            MyMessageFromContact message = messageDao.findById(messageId);
            if (message != null) {
                messageDao.delete(message);
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
