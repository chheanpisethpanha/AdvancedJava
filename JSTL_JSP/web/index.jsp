<%-- 
    Document   : index
    Created on : Feb 4, 2019, 1:41:21 PM
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
        <form action="NextPage.jsp">
            Username: <input type="text" name="username">
            <input type="submit" value="Click">
        </form>
        
        <form action="ValidationServlet">
            <input type="submit" value="ValidationServlet"> 
        </form>
    </body>
</html>
