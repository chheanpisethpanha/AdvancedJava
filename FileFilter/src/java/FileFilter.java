
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Ztranger
 */
public class FileFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter pw = response.getWriter();
        pw.println("Before Filter...");
        BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));
        String remoteAddr = request.getRemoteAddr();
        String requestURI = ((HttpServletRequest)request).getRequestURI();
        String protocol = request.getProtocol();
        System.out.println(remoteAddr+ "has sent a "+protocol+" request to "+requestURI+"\n");
        bw.write(remoteAddr+" has sent a "+protocol+" request to "+requestURI+"\n");
        bw.close();
        chain.doFilter(request, response);
        pw.println("After filter...");
        //10.10.15.108:8080/FilterTest
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
