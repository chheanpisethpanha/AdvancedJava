
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LogoutServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] ck = req.getCookies();
        HttpSession ses = req.getSession();
        int count = (int) ses.getAttribute("activeUser");
        
        count--;
        for(Cookie cook:ck)
       {
           cook.setValue("");
           cook.setMaxAge(0);          
           resp.addCookie(cook);  
        }             
        RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }
    
}
