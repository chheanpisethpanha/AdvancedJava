import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        PrintWriter pw = resp.getWriter();
        
//        Case 1
        if(username != null){
            if(username.equalsIgnoreCase("Ratanawan")){
                RequestDispatcher success = req.getRequestDispatcher("/SuccessServlet");
                success.forward(req, resp);
                //Passing username value to SuccessServlet
                //req.setAttribute("user" , username);
                
                //Create session and send the data to SuccessServlet
                HttpSession ses = req.getSession();
                ses.setAttribute("username", username);
                
            } 
            else {
                RequestDispatcher fail = req.getRequestDispatcher("/FailServlet");
                fail.forward(req, resp);
            }
        }
        else{
            pw.println("Username must not be empty");
        }

//        Case 2
//        if(username.contains("R") || username.contains("r")){
//            RequestDispatcher success = req.getRequestDispatcher("/SuccessServlet");
//            success.forward(req, resp);
//        }
//        else{
//            RequestDispatcher fail = req.getRequestDispatcher("/FailServlet");
//            fail.forward(req, resp);
//        }
          
//        Case 3
//          for(int i=0; i<username.length(); i++){
//              if(username.charAt(i) == 'R'){
//                  pw.println("Username has 'R' in loop");
//              }
//              else{
//                  pw.println("Username doesn't have 'R' in loop");
//              }
//          }
    }


}
