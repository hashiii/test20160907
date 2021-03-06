package com.mycode;

import java.util.Optional;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.util.resource.ResourceCollection;

public class App {

    public static void main(String[] args) throws Exception {

        String portString = Optional.ofNullable(System.getenv("PORT"))
                .orElse("8080");
        int port = Integer.parseInt(portString);
        Server server = new Server(port);

        WebAppContext ctx = new WebAppContext();

        ResourceCollection resources = new ResourceCollection(new String[]{
            "src/main/webapp/public",
            App.class.getClassLoader().getResource("META-INF/resources/").toURI().toString()
        });
        ctx.setBaseResource(resources);
        //ctx.setContextPath("/shop");
        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(FruitsServlet.class, "/fruitsServlet");
        handler.addServletWithMapping(NotebookServlet.class, "/notebookServlet");
        ctx.setServletHandler(handler);
        /* おまじない ここから */
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
