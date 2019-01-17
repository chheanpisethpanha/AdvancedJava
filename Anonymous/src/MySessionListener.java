import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent e) {
        System.out.println("Session with "+e.getSession().getId()+" is created!");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        System.out.println("Session with "+e.getSession().getId()+" is destroyed");
    }
}
