<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index page</title>
    </head>
    <body>
        <%
            Map<String,String> map = new HashMap<String,String>();
            map.put("color1", "pink");
            map.put("color2", "blue");
            map.put("color3", "black");
            
            session.setAttribute("myName", "Salaza212");
            session.setAttribute("colors", map);
        %>
        <form action="landingPage.jsp">
            <input type="text" name="username">
            <input type="password" name="password">
            <input type="submit" value="Click">
        </form>
    </body>
</html>
