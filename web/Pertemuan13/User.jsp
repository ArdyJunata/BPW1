<%-- 
    Document   : User.jsp
    Created on : Dec 9, 2019, 1:58:15 PM
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
            } else if (login.getGroup() != 2) {
        %>
        <h1>Login Anda tidak berhak masuk ke halaman ini</h1>
        <%
            } else {
        %>
        <h1>Halaman User</h1>
        <%
            }
        %>
    </body>
</html>

