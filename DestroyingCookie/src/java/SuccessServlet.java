
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Cookie ck[] = req.getCookies();
        for(Cookie myCookie: ck){
            out.print("Cookie Name: " + myCookie.getName() + "\nCookie value: \n" + myCookie.getValue());
        }
        resp.setContentType("text/html");
        out.println("<br><a href='HomeServlet'>Logout</a>");
    }
    
}
