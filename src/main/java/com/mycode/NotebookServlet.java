package com.mycode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.jsp.JspException;

@WebServlet("/UploadServlet")
@MultipartConfig(location = "/", maxFileSize = 1048576)

/**
 *
 * @author ryo
 */
public class NotebookServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String acceptTitle = request.getParameter("title");
        String acceptText = request.getParameter("text");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>POSTING COMPLETE ! !</h1>");
            out.println("<p>title</p><p>" + acceptTitle + "</div></p>");
            out.println("<p>text</p><p>" + acceptText + "</p>");
            out.println("<a href ='index.jsp'>Back to top page</a>");
            out.println("</body>");
            out.println("</html>");
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
        //今のところデリート用
        PrintWriter out = response.getWriter();
        String keyNum = request.getParameter("keyNum");
        if (!keyNum.isEmpty()) {
            try {
                AccessToDatabase atd = new AccessToDatabase();
                atd.deleteDatatoDatabase(keyNum);
            } catch (SQLException ex) {
                Logger.getLogger(NotebookServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NotebookServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(NotebookServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JspException ex) {
                Logger.getLogger(NotebookServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        try {
            AccessToDatabase atd = new AccessToDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(NotebookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotebookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(NotebookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JspException ex) {
            Logger.getLogger(NotebookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {//dbaccess
            AccessToDatabase atc = new AccessToDatabase();

            atc.postDataToDatabase(request);
        } catch (SQLException ex) {
            Logger.getLogger(NotebookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotebookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(NotebookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JspException ex) {
            Logger.getLogger(NotebookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }
}
