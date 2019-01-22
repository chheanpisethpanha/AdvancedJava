<%-- 
    Document   : ErrorPage
    Created on : Jan 22, 2019, 2:21:27 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--set this page to an error page-->
<%@page isErrorPage="true"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%= exception%>
    </body>
</html>
