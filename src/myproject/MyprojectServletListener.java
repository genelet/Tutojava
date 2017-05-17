package myproject;

import com.genelet.framework.Config;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
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
        
        Map<String, Object> storage = new HashMap<>();
        String doc_root = config.getDocument_root();
        doc_root = doc_root.substring(0,doc_root.length()-3) + "src";
        File folder = new File(doc_root+"/myproject");
        for (File component : folder.listFiles()) {
            if (component.isDirectory()) {
                String name = component.getPath()+"/component.json";
                System.err.println(name);
                File var = new File(name);
                if (var.exists() && var.isFile()) {
                    JsonObject loc = Config.get_json(name);
                    storage.put(component.getName(), loc);
                }
            }
        }
        sc.setAttribute("storage", storage);
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