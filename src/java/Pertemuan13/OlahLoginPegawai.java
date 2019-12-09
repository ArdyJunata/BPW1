package Pertemuan13;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import pt_pcr.*;

public class OlahLoginPegawai extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            final String loginManager = "admin";
            final String passManager = "123";
            final String loginPegawai = "pegawai";
            final String passPegawai = "123";

            String user = request.getParameter("uname");
            String pass = request.getParameter("pass");
            LoginDataPegawai data;

            RequestDispatcher control;
            if (user.equals(loginManager) && pass.equals(passManager)) {
                HttpSession session = request.getSession();
                data = new LoginDataPegawai();
                data.setUname(user);
                data.setGroup(1);
                session.setAttribute("loginData", data);
                control = request.getRequestDispatcher("PT_PCR/daftar_pegawai.jsp");
            } else if (user.equals(loginPegawai) && pass.equals(passPegawai)) {
                HttpSession session = request.getSession();
                data = new LoginDataPegawai();
                data.setUname(user);
                data.setGroup(2);
                session.setAttribute("loginData", data);
                control = request.getRequestDispatcher("PT_PCR/daftar_pegawai.jsp");
            } else {
                control = request.getRequestDispatcher("PT_PCR/errorLogin.jsp");
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
