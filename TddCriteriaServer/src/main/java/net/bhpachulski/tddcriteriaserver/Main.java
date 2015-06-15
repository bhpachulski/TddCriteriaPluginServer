package net.bhpachulski.tddcriteriaserver;

import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

/**
 *
 * @author bhpachulski
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "10080";
        }

        tomcat.setPort(Integer.valueOf(webPort));
        
        Context context = tomcat.addWebapp("/tddCriteria", new File(webappDirLocation).getAbsolutePath());
        File configFile = new File(webappDirLocation + "WEB-INF/web.xml");
        context.setConfigFile(configFile.toURI().toURL());

        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());
        
        tomcat.start();
        tomcat.getServer().await();
    }

}