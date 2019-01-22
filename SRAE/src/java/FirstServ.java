
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        sleep();
        req.setAttribute("school", "KIT");
        sleep();
        req.setAttribute("school", "Kirirom Institute of Technology");
        sleep();
        req.removeAttribute("school");
        sleep();
        resp.getWriter().println();
    }
    public void sleep(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FirstServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
