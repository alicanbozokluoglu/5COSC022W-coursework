// This is the package name.
package com.mlops.api;

// This gets IOException.
import java.io.IOException;

// This gets logger.
import java.util.logging.Logger;

// This gets request context.
import javax.ws.rs.container.ContainerRequestContext;

// This gets request filter.
import javax.ws.rs.container.ContainerRequestFilter;

// This gets response context.
import javax.ws.rs.container.ContainerResponseContext;

// This gets response filter.
import javax.ws.rs.container.ContainerResponseFilter;

// This gets provider.
import javax.ws.rs.ext.Provider;

// This is the logging filter.
@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    // This is the logger.
    private static final Logger APPLICATIONLOGGER =
            Logger.getLogger(LoggingFilter.class.getName());

    // This logs requests.
    @Override
    public void filter(ContainerRequestContext incomingrequestinformation) throws IOException {

        // This writes the request log.
        APPLICATIONLOGGER.info(
                "Incoming request: "
                        + incomingrequestinformation.getMethod()
                        + " "
                        + incomingrequestinformation.getUriInfo().getRequestUri()
        );
    }

    // This logs responses.
    @Override
    public void filter(

            // This is the request.
            ContainerRequestContext incomingrequestinformation,

            // This is the response.
            ContainerResponseContext outgoingresponseinformation

    ) throws IOException {

        // This writes the response log.
        APPLICATIONLOGGER.info(
                "Outgoing response: "
                        + incomingrequestinformation.getMethod()
                        + " "
                        + incomingrequestinformation.getUriInfo().getRequestUri()
                        + " -> Status: "
                        + outgoingresponseinformation.getStatus()
        );
    }
}