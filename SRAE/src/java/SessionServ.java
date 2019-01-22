
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = req.getSession();
        
        sleep();
        hs.setAttribute("school", "KIT");
        sleep();
        hs.setAttribute("school", "Kirirom Institute of Technology");
        sleep();
        hs.removeAttribute("school");       
    }
    public void sleep(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FirstServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

}
