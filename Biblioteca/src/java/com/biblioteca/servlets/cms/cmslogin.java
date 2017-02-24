package com.biblioteca.servlets.cms;

import com.biblioteca.dao.impl.MyUserDaoImpl;
import com.biblioteca.dao.intf.MyUserDaoIntf;
import com.biblioteca.entitati.MyUser;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class cmslogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = "WEB-INF/cms/cmsmainpage.jsp";
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("nume " + name);
        System.out.println("parola " + password);
        //     validare(name, password);
        if (name == null || name.length() <= 5) {
            request.setAttribute("errorNume", "Username is not validated (Must be longer then 5 chars)");
            System.out.println("validare nume");
        }
        if (password == null || password.length() <= 6) {
            request.setAttribute("errorParola", "Password is not validated (Must be longer then 6 chars)");
            System.out.println("validare parola");
        }
        if (request.getAttribute("errorNume") != null
                || request.getAttribute("errorParola") != null) {
            page = "cmsshowlogin";
            RequestDispatcher rd = request.getRequestDispatcher(page);
            rd.forward(request, response);
        } else {
            DataSource ds = (DataSource) request.getServletContext().getAttribute("dataSource");
            MyUserDaoIntf myUserDao = new MyUserDaoImpl(ds);
            MyUser user = myUserDao.getMyUserByNameAndPassword(name, password);
            System.out.println(user);
            if (user != null) {
                HttpSession session = request.getSession(true);// crearea unei sesiuni
                session.setAttribute("ONLINEUSER", user);
                page = "cmsmainpage";
            } else {
                request.setAttribute("errorAutentificare", "Name or password is wrong");
                page = "cmsshowlogin";
            }
              response.sendRedirect(page);
        }
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
