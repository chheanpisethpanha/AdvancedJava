
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
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        filter chain: pass request to next servlet
//        doFilter is service method
//      
        chain.doFilter(request, response);
//        request.getParameter("");
        System.out.println("doing Filter1");
       
    }

    @Override
    public void destroy() {
        System.out.println("Filter1 Destroyed");
    }

    
    
}
