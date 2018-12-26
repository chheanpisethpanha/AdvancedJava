
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get username value directly from form
        String username = req.getParameter("username");
        
        //handle by using session
//        HttpSession hs = req.getSession();
//        hs.setAttribute("username", username);
        
        //handle by using cookie
        Cookie ck = new Cookie("username", username); //cookie recieve 2 args key & value
        resp.addCookie(ck); //should use the response object with addCookie()
        
        //He uses hyperlink for cookie
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<a href='SecondServlet'>Second</a>");

//        RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
//        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    
}
