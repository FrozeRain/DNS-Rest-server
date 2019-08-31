package net.frozerain.jersey.listener;

import org.h2.tools.Server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

public class ServerListener implements ServletContextListener {
    private Server server = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            server = Server.createTcpServer().start();
            System.out.println("DB SERVER START AT " + server.getURL());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("STOPPING DB SERVER...");
        server.shutdown();
    }
}
