
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Cookie cookie = new Cookie("username", username);
        resp.addCookie(cookie);
        
        PrintWriter pw = resp.getWriter();
        pw.print("Welcome " + username);
        req.setAttribute("username", username);
//        
//        RequestDispatcher rd = req.getRequestDispatcher("/SuccessServlet");
//        rd.forward(req, resp);
        resp.setContentType("text/html");
        pw.print("<a href='SuccessServlet'>Next</a>");
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie myCookie = new Cookie("username", "");
        myCookie.setMaxAge(0);
        resp.addCookie(myCookie);
        
        for()
        
        PrintWriter out = resp.getWriter();
        Cookie ck[] = req.getCookies();
        for(Cookie cook: ck){
            out.print("Cookie Name: " + cook.getName() + "\nCookie value: " + cook.getValue());
        }
        out.print("\nCookie has been destroyed...");
        resp.setContentType("text/html");
        out.print("<a href='index.html'>Login</a>");
    }
        
}
