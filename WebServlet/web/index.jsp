<%-- 
    Document   : index
    Created on : Dec 18, 2018, 8:48:06 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="FirstServ" method="POST">
        <input type="text" name="user">  <%--- form parameter --%>
        <input type="password" name="pass">
        <input type="submit" name="login">
    </form>
        <h1>Hello World!</h1>
    </body>
</html>
