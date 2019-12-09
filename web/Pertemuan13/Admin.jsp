<%-- 
    Document   : Admin
    Created on : Dec 9, 2019, 1:53:00 PM
    Author     : Lab330-29
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Pertemuan13.LoginData login = (Pertemuan13.LoginData) session.getAttribute("loginData");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (login == null) {
        %>
        <h1>Anda belum login</h1>
        <%
            } else if (login.getGroup() != 1) {
        %>
        <h1>Login Anda tidak berhak masuk ke halaman ini</h1>
        <%
            } else {
        %>
        <h1>Halaman Admin</h1>
        <%
            }
        %>
    </body>
</html>
