
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class FailServ extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       PrintWriter pw = resp.getWriter();
       pw.println("Invalid Username or Password");
       resp.setContentType("text/html");
        pw.println("<a href='LogOutServ'> Logout</a>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       PrintWriter pw = resp.getWriter();
       pw.println("Fail from GET");
    }
}