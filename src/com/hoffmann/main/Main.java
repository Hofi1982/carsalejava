package com.hoffmann.main;

import com.hoffmann.web.AutoServlet;
import com.hoffmann.web.AutoListServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setResourceBase("src/main/webapp"); // Statikus erõforrások helyének beállítása
        server.setHandler(context);

        // AutoServlet hozzáadása az új autók felvételéhez
        context.addServlet(new ServletHolder(new AutoServlet()), "/autoservlet");

        // AutoListServlet hozzáadása az autók listájának megjelenítéséhez
        context.addServlet(new ServletHolder(new AutoListServlet()), "/autolist");

        server.start();
        server.join();
    }
}
