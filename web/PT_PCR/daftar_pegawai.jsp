
<%@page import="pt_pcr.PegawaiHome"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pt_pcr.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    LoginDataPegawai login = (LoginDataPegawai) session.getAttribute("loginData");
    String name = login.getUname();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Pegawai> list = PegawaiHome.selectAll();
        %>
        <h2>Selamat datang <%=name%></h2>
        <h3>Daftar Pegawai</h3>
        <table border="1">
            <tr>
                <td>NIP</td>
                <td>Nama Pegawai</td>
                <td>Alamat</td>
                <td>Jabatan</td>
                <%
                    if (login.getGroup() == 1) {
                %>
                <td>Aksi</td>
                <%
                    }
                %>
            </tr>
            <%
                for (int i = 0; i < list.size(); i++) {
                    list.get(i);
            %>
            <tr>
                <td><%= list.get(i).getNip()%></td>
                <td><%= list.get(i).getNamaPegawai()%></td>
                <td><%= list.get(i).getAlamat()%></td>
                <td><%= list.get(i).getJabatan()%></td>
                <%
                    if (login.getGroup() == 1) {
                %>
                <td><a href="http://localhost:8080/ArdyBPW/PT_PCR/
                       formEditPegawai.jsp?nip=<%=list.get(i).getNip()%>">Edit</a>
                    <a href="../DeletePegawaiAction?
                       nip=<%=list.get(i).getNip()%>">Delete</a></td>
                    <%
                        }
                    %>
            </tr>
            <%
                }
            %>
        </table>
        <br>
        <%
            if (login.getGroup() == 1) {
        %>
        <a href="http://localhost:8080/tid-master/PT_PCR/add_pegawai.html">Tambah data lagi</a>
        <%
            }
        %>
    </body>
</html>
