
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FailServ extends HttpServlet {

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
      resp.setContentType("text/html");
      PrintWriter out = resp.getWriter();
      out.print("You're not cool guy Panha, shoo!");
      out.println("<form action='index.jsp'>"
              + "<input type='submit' value='Logout Uncool-y'>");
  }
}
