
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session with " + se.getSession().getId() + " is created...");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session with " + se.getSession().getId() + " is destroyed...");
    }
    
}
