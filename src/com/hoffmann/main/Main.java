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
        context.setResourceBase("src/main/webapp"); // Statikus er�forr�sok hely�nek be�ll�t�sa
        server.setHandler(context);

        // AutoServlet hozz�ad�sa az �j aut�k felv�tel�hez
        context.addServlet(new ServletHolder(new AutoServlet()), "/autoservlet");

        // AutoListServlet hozz�ad�sa az aut�k list�j�nak megjelen�t�s�hez
        context.addServlet(new ServletHolder(new AutoListServlet()), "/autolist");

        server.start();
        server.join();
    }
}
