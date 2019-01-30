<%@page errorPage="Error.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%= (String)session.getAttribute("name")%>
        <%= pageContext.getAttribute("name", PageContext.SESSION_SCOPE)  %>
        <%
            out.println(config.getInitParameter("color"));
        %>
        
        <%= application.getInitParameter("school") %>
    </body>
</html>
