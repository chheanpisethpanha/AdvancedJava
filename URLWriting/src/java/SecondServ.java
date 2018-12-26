
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SecondServ extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println(req.getParameter("user"));
        PrintWriter pw = resp.getWriter();
        String user = req.getParameter("user");
        pw.print(user);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       resp.getWriter().println(req.getParameter("user"));
        PrintWriter pw = resp.getWriter();
        String user = req.getParameter("user");
        pw.println(user);
        
    }
    
}
