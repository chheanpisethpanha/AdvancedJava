
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;


public class MyServletRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("The request destroy");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
