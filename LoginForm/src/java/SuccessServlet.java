
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.println("Success from post");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        //get username value from FirstServlet
//        String username = (String) req.getAttribute("user");

        //get session and username value
        HttpSession ses = req.getSession();
        String username = (String) ses.getAttribute("username");
        resp.setContentType("text/html");
        pw.print("Welcome to the pink web " + username + " !");
        pw.print("<a href='LogOutServlet'>Logout</a>");
        
    }
}
