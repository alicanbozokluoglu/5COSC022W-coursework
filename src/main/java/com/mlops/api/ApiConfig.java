// This is the package name.
package com.mlops.api;

// This gets application path.
import javax.ws.rs.ApplicationPath;

// This gets application.
import javax.ws.rs.core.Application;

//This sets API path and API config.
@ApplicationPath("/api/v1")
public class ApiConfig extends Application {
}