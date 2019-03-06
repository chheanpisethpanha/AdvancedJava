<%-- 
    Document   : Next
    Created on : Jan 28, 2019, 1:48:35 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Next</title>
    </head>
    <body>
        <!--Message in Next.jsp-->
        In the next page... 
        <!--Getting parameter from forward-->
        ${param.username} 
        
        <!--To get property-->
        <jsp:useBean id="bean" class="bean.MyBean" scope="session"></jsp:useBean>
        <jsp:getProperty name="bean" property="id"/>
        <jsp:getProperty name="bean" property="name"/>
        
    </body>
</html>
