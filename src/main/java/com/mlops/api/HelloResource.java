// This is the package name.
package com.mlops.api;

// This gets hash map.
import java.util.HashMap;

// This gets map.
import java.util.Map;

// This gets GET.
import javax.ws.rs.GET;

// This gets path.
import javax.ws.rs.Path;

// This gets produces.
import javax.ws.rs.Produces;

// This gets media type.
import javax.ws.rs.core.MediaType;

// This is the home resource.
@Path("/")
public class HelloResource {

    // This is GET.
    @GET

    // This gives JSON.
    @Produces(MediaType.APPLICATION_JSON)

    // This shows API information.
    public Map<String, Object> discovery() {

        // This keeps API information.
        Map<String, Object> applicationinformation = new HashMap<>();

        // This sets the API name.
        applicationinformation.put("apiName", "MLOps Pipeline Management API");

        // This sets the version.
        applicationinformation.put("version", "1.0");

        // This sets the admin contact.
        applicationinformation.put("adminContact", "w2167917@westminster.ac.uk");

        // This keeps all resources.
        Map<String, String> applicationresources = new HashMap<>();

        // This sets workspaces.
        applicationresources.put("workspaces", "/api/v1/workspaces");

        // This sets models.
        applicationresources.put("models", "/api/v1/models");

        // This sets metrics.
        applicationresources.put("metrics", "/api/v1/models/{modelId}/metrics");

        // This adds resources.
        applicationinformation.put("resources", applicationresources);

        // This gives API information.
        return applicationinformation;
    }

    // This is GET.
    @GET

    // This sets the path.
    @Path("/crash")

    // This gives JSON.
    @Produces(MediaType.APPLICATION_JSON)

    // This makes a test error.
    public String crash() {

        // This throws an error.
        throw new NullPointerException("Demo crash");
    }
}