
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServ extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        
        String name = req.getParameter("user");
        //resp.getWriter().println("<a href='SecondServ?user="+name+"'>Second</a>");
        PrintWriter pw = resp.getWriter();
        
        pw.println("<form action='SecondServ'>"
                    +"<input type='hidden' name='user' value='"+name+"'>"
                    +"<input type='submit' value='Second'>"
                    +"</form>");
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
}