// This is the package name.
package com.mlops.api;

// This gets media type.
import javax.ws.rs.core.MediaType;

// This gets response.
import javax.ws.rs.core.Response;

// This gets exception mapper.
import javax.ws.rs.ext.ExceptionMapper;

// This gets provider.
import javax.ws.rs.ext.Provider;

// This is the exception mapper.
@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable> {

    // This handles all errors.
    @Override
    public Response toResponse(Throwable caughtapplicationexception) {

        // This gives an error response.
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)

                // This sets JSON.
                .type(MediaType.APPLICATION_JSON)

                // This sets the error message.
                .entity(new ErrorResponse("An unexpected internal server error occurred."))

                // This builds the response.
                .build();
    }
}