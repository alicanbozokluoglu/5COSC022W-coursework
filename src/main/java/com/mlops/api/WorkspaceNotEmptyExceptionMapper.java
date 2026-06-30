// This is the package name.
package com.mlops.api;

// This gets exception mapper.
import javax.ws.rs.ext.ExceptionMapper;

// This gets provider.
import javax.ws.rs.ext.Provider;

// This gets media type.
import javax.ws.rs.core.MediaType;

// This gets response.
import javax.ws.rs.core.Response;

// This is the workspace error mapper.
@Provider
public class WorkspaceNotEmptyExceptionMapper implements ExceptionMapper<WorkspaceNotEmptyException> {

    // This handles the error.
    @Override
    public Response toResponse(WorkspaceNotEmptyException caughtworkspaceexception) {

        // This gives an error response.
        return Response.status(Response.Status.CONFLICT)

                // This sets JSON.
                .type(MediaType.APPLICATION_JSON)

                // This sets the error message.
                .entity(new ErrorResponse(caughtworkspaceexception.getMessage()))

                // This builds the response.
                .build();
    }
}