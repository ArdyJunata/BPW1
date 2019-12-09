/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan12;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pt_pcr.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Lab330-29
 */
public class DeletePegawaiAction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String pesan = null;
            String nip = request.getParameter("nip");
            PegawaiHome pegawaiBean = new PegawaiHome();
            if(pegawaiBean.delete(nip) == true) {
                pesan = "Pegawai dengan nip" + nip + "berhasil dihapus";
            } else {
                pesan = "Pegawai dengan nip" + nip + "gagal dihapus";
            }
            request.setAttribute("pesan", pesan);
            request.setAttribute("nip", nip);
            
            request.setAttribute("pesan", pesan);
            
            RequestDispatcher dispatcher = null;
            dispatcher = request.getRequestDispatcher("PT_PCR/afterDeletePegawai.jsp");
            dispatcher.forward(request, response);
        } finally {
            out.close();
        }
    }
}
