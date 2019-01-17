import javax.servlet.ServletContext;
import java.io.IOException;

public class MyServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ServletContext ctx = getServletContext();  //common attribute for the whole application

        ctx.setAttribute("name", "Panha"); //context shutdown when we undeploy
        sleep();
        ctx.setAttribute("name", "Wann");
        sleep();
        ctx.removeAttribute("name");
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
            System.out.println("Loading...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
