import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionAttListener implements HttpSessionAttributeListener{

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("New Attribute " + event.getName() + " with the value " + event.getValue() + " is added...");
        stop();
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("Attribute " + event.getName() + " is removed.. The current value is " + event.getValue() );
        stop();
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Attribute " + event.getName() + " is replaced with " + event.getValue());
        stop();
    }
          
    public void stop(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            
        }
    }
}
