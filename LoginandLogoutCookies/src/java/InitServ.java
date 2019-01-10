
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class InitServ extends HttpServlet {
    private static int count = 0;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses = req.getSession();
        ses.setAttribute("activeUser",count);
        if(count == 0)
        {
            count++;
        }
        else{if (count!=0)
                count++;
                }
        String user = req.getParameter("user");
        
        Cookie ck = new Cookie("user", user);
        resp.addCookie(ck);
        
        if(user.equalsIgnoreCase("panha"))
        {
            RequestDispatcher rd = req.getRequestDispatcher("/SuccessServ");
            rd.forward(req, resp); 
        }
        else
        {
            RequestDispatcher rd = req.getRequestDispatcher("/FailServ");
            rd.forward(req, resp);
        }
       
        
    }
    
  
}
