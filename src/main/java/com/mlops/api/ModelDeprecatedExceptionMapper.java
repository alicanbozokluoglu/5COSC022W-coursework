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

// This is the model error mapper.
@Provider
public class ModelDeprecatedExceptionMapper implements ExceptionMapper<ModelDeprecatedException> {

    // This handles the error.
    @Override
    public Response toResponse(ModelDeprecatedException caughtmodelexception) {

        // This gives an error response.
        return Response.status(Response.Status.FORBIDDEN)

                // This sets JSON.
                .type(MediaType.APPLICATION_JSON)

                // This sets the error message.
                .entity(new ErrorResponse(caughtmodelexception.getMessage()))

                // This builds the response.
                .build();
    }
}