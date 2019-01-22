import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletReqListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("A request object is destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("A new request object is created");
    }
}
