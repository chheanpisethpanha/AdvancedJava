
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 *
 * @author Admin
 */
public class SessionAttrListener implements HttpSessionAttributeListener{

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Session Name: '"+event.getName()+"; Value: '"+event.getValue()+" - is added from Session scope.");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("Session Name: '"+event.getName()+"; Value: '"+event.getValue()+" - is removed from Session scope.");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Session Replaced in Session Scope");
    }
    
}
