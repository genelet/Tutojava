package myproject;

import com.genelet.framework.Config;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyprojectServletListener implements ServletContextListener {
@Override
  public void contextInitialized(ServletContextEvent event) {
    ServletContext sc = event.getServletContext();
    System.err.println(sc.getInitParameter("config.filename"));
    String f = (String) sc.getInitParameter("config.filename");
    try {
        Config config = new Config(f);
        sc.setAttribute("config", config);
    } catch (IOException ex) {
        Logger.getLogger(MyprojectServletListener.class.getName()).log(Level.SEVERE, null, ex);
    }
    sc.setAttribute("jdbctype", sc.getInitParameter("jdbc.type"));
    System.err.println("Genelet Server Starts ...");
   }

   @Override
   public void contextDestroyed(ServletContextEvent arg0) {
   }
}