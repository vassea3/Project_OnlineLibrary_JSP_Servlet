package com.biblioteca.servlets.cms;

import com.biblioteca.dao.impl.DeleteFile;
import com.biblioteca.dao.impl.FileSaveDao;
import com.biblioteca.dao.impl.MyBookDaoImpl;
import com.biblioteca.dao.intf.MyBookDaoIntf;
import com.biblioteca.entitati.MyBook;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

@WebServlet(name = "cmsaddbook", urlPatterns = {"/cmsaddbook"})
@MultipartConfig
public class cmsaddbook extends HttpServlet {

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
            String bookName = request.getParameter("bookName");
            String author = request.getParameter("author");
            String gender = request.getParameter("gender");
            String summary = request.getParameter("summary");

            List<MyBook> listaBooks = bookDao.findAll();
            Set<String> fileNameDB = new HashSet<>();
            Set<String> bookImageNameDB = new HashSet<>();
            listaBooks.stream().map((MyBook listaBook) -> {
                fileNameDB.add(listaBook.getFileName());
                return listaBook;
            }).forEachOrdered((listaBook) -> {
                bookImageNameDB.add(listaBook.getBookImageName());
            });
            MyBook bookFromDB = bookDao.findById(bookId);

            InputStream fileNameByte = null;
            Part filePart = request.getPart("fileName");
            String fileName = FileSaveDao.getFileName(filePart);
            if (fileName.isEmpty() && bookId > 0) {
                fileName = bookFromDB.getFileName();
                fileNameByte = bookFromDB.getFileBytes();
            } else if (fileName.isEmpty() && bookId == 0) {
                page = "cmsshowaddbook?bookId=" + bookId;
                request.setAttribute("eroare", "Select a file");
            } else {

                String filePath = request.getServletContext().getRealPath("");
                fileNameByte = FileSaveDao.addFile(filePart, fileName, filePath);
            }
            InputStream fileImageBytes = null;
            Part fileImagePart = request.getPart("bookImageName");
            String fileImageName = FileSaveDao.getFileName(fileImagePart);
            if (fileImageName.isEmpty() && bookId > 0) {
                fileImageName = bookFromDB.getBookImageName();
                fileImageBytes = bookFromDB.getBookImageBytes();
            } else if (fileImageName.isEmpty() && bookId == 0) {
                page = "cmsshowaddbook?bookId=" + bookId;
                request.setAttribute("eroare", "Select a file");
            } else {
                String fileImagePath = request.getServletContext().getRealPath("");
                fileImageBytes = FileSaveDao.addFile(fileImagePart, fileImageName, fileImagePath);
            }
            MyBook bookFromPage = new MyBook(bookId, bookName, author, gender, summary, fileName, fileNameByte, fileImageName, fileImageBytes);

            if (bookId == 0) {
                if (fileNameDB.contains(fileName)) {
                    page = "cmsshowaddbook?bookId=" + bookId;
                    request.setAttribute("eroare", "File with this name exists. Change the file name");
                } else if (bookImageNameDB.contains(fileImageName)) {
                    page = "cmsshowaddbook?bookId=0";
                    request.setAttribute("eroare", "File with this name exists. Change the file name");
                } else {

                    bookDao.save(bookFromPage);
                    request.setAttribute("bookName", bookName + " was added");
                }
            } else {
                File bookFile = new File("C:\\Users\\Taniusha\\Documents\\NetBeansProjects\\Biblioteca\\web\\resources\\bookFiles/" + bookFromDB.getFileName());
                DeleteFile.DeleteFile(bookFile);
                File imageFile = new File("C:\\Users\\Taniusha\\Documents\\NetBeansProjects\\Biblioteca\\web\\resources\\images/bookImages/" + bookFromDB.getBookImageName());
                DeleteFile.DeleteFile(imageFile);

                if (bookFromDB != null) {
                    bookFromDB.setBookName(bookName);
                    bookFromDB.setAuthor(author);
                    bookFromDB.setGender(gender);
                    bookFromDB.setSummary(summary);
                    bookFromDB.setFileName(fileName);
                    bookFromDB.setFileBytes(fileNameByte);
                    bookFromDB.setBookImageName(fileImageName);
                    bookFromDB.setBookImageBytes(fileImageBytes);
                    bookDao.update(bookFromDB);
                    request.setAttribute("bookName", bookName + " was edited");
                }
            }
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
