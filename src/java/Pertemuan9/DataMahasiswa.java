/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan9;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lab330-32
 */
public class DataMahasiswa extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        try {
            String nim = request.getParameter("nim");
            MahasiswaFacade mahasiswaFacade = new MahasiswaFacade();
            Mahasiswa mahasiswa = null;
            Mahasiswa[] daftarMahasiswas = mahasiswaFacade.getDataMahasiswa(nim);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DataMahasiswa</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Data Mahasiswa</h1>");
            out.println("<hr />");
            out.printf("<table>");
            for (Mahasiswa daftarMahasiswa : daftarMahasiswas) {
                out.printf("<tr>"
                        + "<td>NIM</td>"
                        + "<td>:</td>"
                        + "<td>%s</td>"
                        + "</tr>", daftarMahasiswa.getNim());
                out.printf("<tr>"
                        + "<td>Nama Mahasiswa</td>"
                        + "<td>:</td>"
                        + "<td>%s</td>"
                        + "</tr>", daftarMahasiswa.getNamaMhs());
                out.printf("<tr>"
                        + "<td>Program Studi</td>"
                        + "<td>:</td>"
                        + "<td>%s</td>"
                        + "</tr>", daftarMahasiswa.getProdi());
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
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
