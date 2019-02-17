
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Employee> list = new ArrayList();
        list.add(new Employee(1, "Ratanawan"));
        list.add(new Employee(2, "Sothea"));
        list.add(new Employee(3, "Lynan"));
        list.add(new Employee(4, "Jenny"));
        list.add(new Employee(5, "Manich"));
        
        request.setAttribute("emp", list);
        
        request.getRequestDispatcher("PrintEmployee.jsp").forward(request, response);
    }

}
