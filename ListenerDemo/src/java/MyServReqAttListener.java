import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyServReqAttListener implements ServletRequestAttributeListener{

    @Override
    public void attributeAdded(ServletRequestAttributeEvent s) {
        System.out.println("New Attribute " + s.getName() + " with the value " + s.getValue() + " is added...");
        stop();
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent s) {
        System.out.println("Attribute " + s.getName() + " is removed.. The current value is " + s.getValue() );
        stop();
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent s) {
        System.out.println("Attribute " + s.getName() + " is replaced with " + s.getValue());
        stop();
    }
    
    public void stop() {
        try {
            Thread.sleep(3000);
            }
        catch (InterruptedException ex) {
            System.out.println("sleep exception...");
        }
    }
}
