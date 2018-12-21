
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutServlet extends HttpServlet {
    
    public static void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession ses = req.getSession();
        ses.invalidate();
        req.getRequestDispatcher("index.html").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logOut(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logOut(req,resp);
    }
    
}
