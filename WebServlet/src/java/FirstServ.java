
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Ztranger
 */
public class FirstServ extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
       pw.println("Post method invoked");
       
       String userName = req.getParameter("user");
       String passWord = req.getParameter("pass");
       
       if(userName.equalsIgnoreCase("panha") && passWord.equals("123" ))
       {
           RequestDispatcher rd = req.getRequestDispatcher("/SuccessServ");       
           //req.setAttribute("userN", userName);
           HttpSession ses = req.getSession();
           ses.setAttribute("user", userName);
           rd.forward(req, resp);
           
       }else {
           RequestDispatcher rdf = req.getRequestDispatcher("/FailServ");
           rdf.include(req, resp);
       }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
       String userName = req.getParameter("user");
        
            PrintWriter out = resp.getWriter();
            
            //if((userName.contains("s") || userName.contains("S")) || userName.equalsIgnoreCase("Panha") )
       
                int check = 0;
                for(int i=0 ; i<userName.length();i++)
                {
                    if(userName.charAt(i) == 's' || userName.charAt(i) == 'S')
                    {
                        check++;
                    }
                }
                if(check++ != 0)
                {
                    out.println("<h1 style=\"color:#d37b00;\">");
                    out.println("Welcome "+userName.toUpperCase());
                    out.println("</h1>");
                }else out.print("Try Again Bruder, REGISTER!");
                
//            out.println("<h1 style=\"color:#d37b00;\">");
//            out.println("Welcome "+userName.toUpperCase());
//            out.println("</h1>");
        
       
    } 
  }

    


