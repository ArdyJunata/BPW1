<%-- 
    Document   : formEditMahasiswa
    Created on : Dec 2, 2019, 1:48:55 PM
    Author     : Lab330-29
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pt_pcr.PegawaiHome"%>
<%@page import="pt_pcr.Pegawai"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String nip = request.getParameter("nip");
            PegawaiHome pegawaiHome = new PegawaiHome();
            Pegawai pegawai = null;

            if (nip != null) {
                pegawai = PegawaiHome.getDataPegawaiByNip(nip);
            }

            String nama = pegawai.getNamaPegawai();
            String alamat = pegawai.getAlamat();
            String jabatan = pegawai.getJabatan();
        %>
        <form action="../UpdateMahasiswaAction" method="post">
            <input type="hidden" value="<%=nip%>" name="nip">
            <h4>Pegawai</h4>
            <table>
                <tr>
                    <td>Nip</td>
                    <td>:</td>
                    <td><input type="text" value="<%=nip%>" name="nipp" disabled></td>
                </tr>
                <tr>
                    <td>Nama Pegawai</td>
                    <td>:</td>
                    <td><input type="text" value="<%=nama%>" name="nama"></td>
                </tr>
                <tr>
                    <td>Alamat</td>
                    <td>:</td>
                    <td><input type="text" value="<%=alamat%>" name="alamat"></td>
                </tr>
                <tr>
                    <td>Jabatan</td>
                    <td>:</td>
                    <td><input type="text" value="<%=jabatan%>" name="jabatan"></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td><input type="submit" value="edit"><input type="reset" value="reset"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
