
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextServletListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context for your servlet is created...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context is destroyed...");
    }
    
}
