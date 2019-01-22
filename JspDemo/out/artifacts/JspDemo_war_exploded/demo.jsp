<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/21/2019
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--<%!--%>
    <%--String name = "Batch 4", school = "KIT";--%>
        <%--public int test(int a, int b)--%>
        <%--{--%>
            <%--return a+b;--%>
        <%--}//only var or func no execute--%>
        <%--//aka declaration--%>
    <%--%>--%>

    <%--<%= test(10,20)%>--%>
    <%--<%= name+school%>--%>
    <%  //scriptlet tag
        String name1 = request.getParameter("name");
        if(name1.equals("Panha"))
        {
            session.setAttribute("name", name1);
            out.print("COLOR : "+config.getInitParameter("color"));
            //request.getRequestDispatcher("Success.jsp").forward(request, response);
        }else
        {
            request.getRequestDispatcher("Failure.jsp").forward(request, response);
        }
    %>
    <%= "Welcome : " +name1%>

</body>
</html>
