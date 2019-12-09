
package Pertemuan12;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pt_pcr.*;
import javax.servlet.RequestDispatcher;

public class UpdateMahasiswaAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String pesan = null;
            String nip = request.getParameter("nip");
            String nama = request.getParameter("nama");
            String alamat = request.getParameter("alamat");
            String jabatan = request.getParameter("jabatan");
            
            Pegawai pegawai = new Pegawai();
            pegawai.setNip(nip);
            pegawai.setNamaPegawai(nama);
            pegawai.setJabatan(jabatan);
            pegawai.setAlamat(alamat);
            
            PegawaiHome pegawaiBean = new PegawaiHome();
            if(pegawaiBean.store(pegawai)==true) {
                pesan = "Berhasil disimpan";
            } else {
                pesan = "Gagal untuk disimpan";
            }
            request.setAttribute("pesan", pesan);
            request.setAttribute("pegawai", pegawai);
            
            RequestDispatcher dispatcher = null;
            dispatcher = request.getRequestDispatcher("PT_PCR/afterUpdatePegawai.jsp");
            dispatcher.forward(request, response);
        } finally {
            out.close();
        }
    }

}
