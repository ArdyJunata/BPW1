/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan13;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Lab330-29
 */
public class OlahLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            final String loginAdmin = "Administator";
            final String passAdmin = "ppp";
            final String loginUser1 = "user1";
            final String passUser1 = "uuu";
            final String loginUser2 = "user2";
            final String passUser2 = "eee";

            String user = request.getParameter("uname");
            String pass = request.getParameter("pass");

            RequestDispatcher control;
            if (user.equals(loginAdmin) && pass.equals(passAdmin)) {
                HttpSession session = request.getSession();
                LoginData data = new LoginData();
                data.setUname(user);
                data.setGroup(1);
                session.setAttribute("loginData", data);
                control = request.getRequestDispatcher("Pertemuan13/Admin.jsp");
            } else if (user.equals(loginUser1) && pass.equals(passUser1)) {
                HttpSession session = request.getSession();
                LoginData data = new LoginData();
                data.setUname(user);
                data.setGroup(2);
                session.setAttribute("loginData", data);
                control = request.getRequestDispatcher("Pertemuan13/User.jsp");
            } else if (user.equals(loginUser2) && pass.equals(passUser2)) {
                HttpSession session = request.getSession();
                LoginData data = new LoginData();
                data.setUname(user);
                data.setGroup(2);
                session.setAttribute("loginData", data);
                control = request.getRequestDispatcher("Pertemuan13/User.jsp");
            } else {
                control = request.getRequestDispatcher("Pertemuan13/ErrorLogin.jsp");
            }
            control.forward(request, response);
        } finally {
            out.close();
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
