<%@page errorPage="Error.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String name = request.getParameter("name");
            if(name.equals("Muny"))
            {
                //int x = 10/0;
             //   session.setAttribute("name", name);
             pageContext.setAttribute("name", name, PageContext.SESSION_SCOPE);
                request.getRequestDispatcher("/Success").
                        forward(request, response);
            }
            else
            {
                request.getRequestDispatcher("/Failure").forward(request, response);
            }    
        %>
    </body>
</html>
