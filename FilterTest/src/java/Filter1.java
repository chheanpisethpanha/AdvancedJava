
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter1 implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter1 Invoked");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
///       filter chain: pass request to next servlet
///        doFilter is service method   

        System.out.println("doing Filter1");
        String email = request.getParameter("email");
        String user = request.getParameter("user");
        
///Check null object or empty value
          if((email == null||email.equals("")) || (user == null || user.equals("")))
        {
             request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            chain.doFilter(request, response);  
        }
       
    }
    @Override
    public void destroy() {
        System.out.println("Filter1 Destroyed");
    }  
}
