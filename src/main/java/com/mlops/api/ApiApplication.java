// This is the package name.
package com.mlops.api;

// This gets URI.
import java.net.URI;

// This gets Grizzly server.
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

// This gets resource config.
import org.glassfish.jersey.server.ResourceConfig;

// This starts the API.
public class ApiApplication {

    // This is the server address.
    public static final String APPLICATIONSERVERADDRESS = "http://localhost:9090/api/v1/";

    // This starts the program.
    public static void main(String[] applicationstartarguments) {

        // This is the resource config.
        ResourceConfig applicationresourceconfiguration = new ResourceConfig();

        // This gets API package.
        applicationresourceconfiguration.packages("com.mlops.api");

        // This starts the server.
        GrizzlyHttpServerFactory.createHttpServer(

                // This is the server address.
                URI.create(APPLICATIONSERVERADDRESS),

                // This is the resource config.
                applicationresourceconfiguration
        );

        // This shows the server address.
        System.out.println("MLOps API is running at: " + APPLICATIONSERVERADDRESS);

        // This shows the stop message.
        System.out.println("Press Ctrl+C to stop the server.");
    }
}