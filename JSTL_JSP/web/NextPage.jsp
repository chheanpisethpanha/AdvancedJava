<%-- 
    Document   : NextPage
    Created on : Feb 4, 2019, 1:57:44 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cr" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Next Page</title>
    </head>
    
        <!--Declaring a variable name 'name' with value 'Ratanawan'-->
        Hey <cr:set var="name" value="Ratanawan"/> !
        
        <!--Printing the variable-->
        <cr:out value="${name}"></cr:out>
        
        <!--Get parameter from the form-->
        <cr:set var="username" value="${param.username}"/>
        
        <!--Print the parameter got from the form-->
        <cr:out value="${username}"></cr:out>
        
        <!--To remove a variable from any scope-->
        <cr:remove var="name"/>
        
        <!--To declare a variable in a scope-->
        <cr:set var="batch" value="Batch4" scope="session"/>
        
        <br>
        print before remove 'batch' from the session: 
        <cr:out value="${batch}"></cr:out>
        
        <!--To Destroy a variable in the session-->
        <cr:remove var="batch" scope="session"/>
        
        <br>
        print after remove 'batch' from the session:
        <cr:out value="${batch}"></cr:out> 
        <!--The line above doesn't show null because the variable is empty during the execution time and it is collected by the garbage collector -->
        
</html>
