 <%--
    Document   : index
    Created on : Jan 28, 2019, 1:47:18 PM
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
        <!--Message in index.jsp-->
        Yo! This is index!
   
        <!--To include this file and the next file-->
        <%-- <jsp:include page="Next.jsp"/> --%>
        
        <!--To set property-->
        <!--Create object for Mybean class-->
        <jsp:useBean id="bean" class="bean.MyBean" scope="session"></jsp:useBean> 
        
        <!--This line will print id-->
        <jsp:setProperty name="bean" property="id" value="212"/>
        <!--This line will print name-->
        <jsp:setProperty name="bean" property="name" value="Ratanawan"/>
        
         <%--To forward to the next JSP file--%>
        <jsp:forward page="Next.jsp">
            <jsp:param  value="Ratanawan" name="username"/> 
        </jsp:forward>
        
<!--    <a href="Next.jsp">Click here to go to Next page</a>
        <br>
        <a href="ErrorPage.jsp">Click here to go to Error Page</a>
        <br>
        <a href="HandleArithmeticException.jsp">Click here to go to Arithmetic Exception</a>
        <br>-->
    </body>
</html>
