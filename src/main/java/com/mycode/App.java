package com.mycode;

import java.util.Optional;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;

public class App {

    public static void main(String[] args) throws Exception {

        String portString = Optional.ofNullable(System.getenv("PORT"))
                .orElse("8080");
        int port = Integer.parseInt(portString);
        Server server = new Server(port);

        WebAppContext ctx = new WebAppContext();
        ctx.setResourceBase("src/main/webapp/public");//ここでindexとかを決めるみたい？
//        ctx.setContextPath("/shop");
        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(FruitsServlet.class, "/fruitsServlet");
        handler.addServletWithMapping(NotebookServlet.class, "/notebookServlet");
        ctx.setServletHandler(handler);
        /* おまじない ここから */
        // http://localhost:8080/webjars/jquery/2.2.3/jquery.min.js
        // http://www.programcreek.com/java-api-examples/index.php?api=org.eclipse.jetty.webapp.WebInfConfiguration
        // Example 17
        ctx.setAttribute(WebInfConfiguration.CONTAINER_JAR_PATTERN, ".*/org\\.eclipse\\.xtext\\.web.*,.*/org.webjars.*");
        ctx.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/[^/]*jstl.*\\.jar$");
        org.eclipse.jetty.webapp.Configuration.ClassList classlist = org.eclipse.jetty.webapp.Configuration.ClassList.setServerDefault(server);
        classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration", "org.eclipse.jetty.plus.webapp.EnvConfiguration", "org.eclipse.jetty.plus.webapp.PlusConfiguration");
        classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration");
        /* おまじない ここまで */

        server.setHandler(ctx);
        server.start();
        server.join();
    }
}
