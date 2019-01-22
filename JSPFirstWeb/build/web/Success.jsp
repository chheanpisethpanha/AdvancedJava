<%-- 
    Document   : Success
    Created on : Jan 21, 2019, 2:46:08 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success.jsp</title>
    </head>
    <body>
        <% out.println("Welcome..." + session.getAttribute("username"));%>
    </body>
</html>
