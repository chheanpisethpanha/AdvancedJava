<%-- 
    Document   : First
    Created on : Jan 21, 2019, 2:45:49 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--All error will be handle by ErrorPage.jsp-->
<%@page errorPage="ErrorPage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>First.jsp</title>
    </head>
    <body>
          <!--declare variable-->
        <%!String name = "Batch4", school="KIT"; 
            public int test(int a, int b)
            {
                return a/b;
            }
        %>
        
        <!--print result-->
        <%= "This is in Expression tag" %>
        <br>
        <%= test(20,40) %>
        <br>
        <%= name + " " + school %>
        <br>
        <%= (10*20)/20 %>
        <br>
        
        <!--logic-->
        <% 
            String username = request.getParameter("username");
            out.println("This is in Scriptlet tag\n");
            //Forward the parameter throught session
            if(username.equals("Ratanawan")){
                session.setAttribute("username", username);
                request.getRequestDispatcher("Success.jsp").forward(request,response);
            }
            else if(username.equals("Color")){
                //Get Config parameter
                out.println("\nColor: " + config.getInitParameter("Color") + " Yayyy!!!");
            }
            else if(username.equals("School")){
                out.println("\nOur school is: " + application.getInitParameter("school"));
            }
            else if(username.equals("divide")){
                out.println(test(10,0));
            }
            else {
                request.getRequestDispatcher("Failure.jsp").forward(request,response);
            }

        %>
    </body>
</html>
