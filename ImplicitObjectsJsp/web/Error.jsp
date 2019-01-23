<%@page import="java.lang.ArithmeticException"%>
<%@page import="java.lang.ArrayIndexOutOfBoundsException" %>
<%@page extends="java.lang.Thread" %>
<%@page isErrorPage="true" %>
<%@page language="java" %>
<%@page autoFlush="true" %>

<%@include file="Header.jsp" %>
<%@include file="Footer.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            div{
                display: block;
                position: absolute;
            }
            
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            exception.printStackTrace();
        %>
    </body>
</html>
