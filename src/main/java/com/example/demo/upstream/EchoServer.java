package com.example.demo.upstream;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class EchoServer {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(18080);
        tomcat.getConnector(); // Trigger the creation of the default connector

        // Add context
        var ctx = tomcat.addContext("", null);

        // Add servlet
        Tomcat.addServlet(ctx, "QueryEchoServlet", new QueryEchoServlet());
        ctx.addServletMappingDecoded("/query", "QueryEchoServlet");

        tomcat.start();
        tomcat.getServer().await();
    }
}
