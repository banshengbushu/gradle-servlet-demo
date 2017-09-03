package com.mind.server;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;


public class JettyServer {

    public static void main(String[] args) throws Exception {

        System.out.println("Success!  Server start on 8081 port!");

        Server server = new Server(8081);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new FirstServlet()), "/index");
        context.addServlet(new ServletHolder(new FirstServlet("")), "/hello/web");
        context.addServlet(new ServletHolder(new HelloWorld("111111111","22222222222")), "/home");
        context.addServlet(new ServletHolder(new SubmitServlet("")), "/SubmitServlet");

        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }
}