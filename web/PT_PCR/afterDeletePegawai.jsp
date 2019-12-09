<%-- 
    Document   : afterUpdatePegawai
    Created on : Dec 2, 2019, 3:30:21 PM
    Author     : Lab330-29
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pt_pcr.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="pegawai" class="pt_pcr.Pegawai" />
        <%
            pegawai = (pt_pcr.Pegawai) request.getAttribute("pegawai");
            String pesan = (String)request.getAttribute("pesan");
        %>
        <h1>Penghapusan Data </h1>
        <br/> 
        <br>
        <h3><%=pesan%></h3>
        <a href="PT_PCR/add_pegawai.html">Tambah Pegawai</a><br>
        <a href="PT_PCR/daftar_pegawai.jsp">Lihat daftar Pegawai</a>
    </body>
</html>
