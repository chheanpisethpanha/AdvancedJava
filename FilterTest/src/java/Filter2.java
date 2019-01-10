
import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Filter2 implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter2 Invoked");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
          String email = request.getParameter("email");
          String user = request.getParameter("user");

///To Check for Special character
        int a = 0;
        if(!Pattern.matches("[A-Za-z]+", user)){
            a++;
        }
        
///Condition: User contains no Special character, EMAIL need to be proper
        if(a > 0 || !(email.contains("@") && email.contains(".")))
        {      
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
            else
        {
            chain.doFilter(request, response);
        }
}

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

