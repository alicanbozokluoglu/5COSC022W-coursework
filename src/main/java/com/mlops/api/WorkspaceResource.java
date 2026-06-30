// This is the package name.
package com.mlops.api;

// This gets list.
import java.util.List;

// This gets DELETE.
import javax.ws.rs.DELETE;

// This gets GET.
import javax.ws.rs.GET;

// This gets POST.
import javax.ws.rs.POST;

// This gets consumes.
import javax.ws.rs.Consumes;

// This gets path.
import javax.ws.rs.Path;

// This gets path param.
import javax.ws.rs.PathParam;

// This gets produces.
import javax.ws.rs.Produces;

// This gets media type.
import javax.ws.rs.core.MediaType;

// This gets response.
import javax.ws.rs.core.Response;

// This is workspace resource.
@Path("/workspaces")
public class WorkspaceResource {

    // This is GET.
    @GET

    // This gives JSON.
    @Produces(MediaType.APPLICATION_JSON)

    // This gets all workspaces.
    public List<MLWorkspace> getallworkspaces() {

        // This gives all workspaces.
        return DataStore.allworkspaceinformation;
    }

    // This is POST.
    @POST

    // This reads JSON.
    @Consumes(MediaType.APPLICATION_JSON)

    // This gives JSON.
    @Produces(MediaType.APPLICATION_JSON)

    // This makes a new workspace.
    public Response createnewworkspace(MLWorkspace newworkspaceinformation) {

        // This adds the workspace.
        DataStore.allworkspaceinformation.add(newworkspaceinformation);

        // This gives created workspace.
        return Response.status(Response.Status.CREATED)
                .entity(newworkspaceinformation)
                .build();
    }

    // This is GET.
    @GET

    // This sets the path.
    @Path("/{workspaceId}")

    // This gives JSON.
    @Produces(MediaType.APPLICATION_JSON)

    // This gets one workspace.
    public Response getworkspacebyidentifier(

            // This is workspace ID.
            @PathParam("workspaceId") String workspaceidentifier
    ) {

        // This checks all workspaces.
        for (MLWorkspace currentworkspaceinformation : DataStore.allworkspaceinformation) {

            // This checks workspace ID.
            if (currentworkspaceinformation.getWorkspaceidentifier()
                    .equals(workspaceidentifier)) {

                // This gives the workspace.
                return Response.ok(currentworkspaceinformation).build();
            }
        }

        // This gives not found.
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorResponse("Workspace not found"))
                .build();
    }

    // This is DELETE.
    @DELETE

    // This sets the path.
    @Path("/{workspaceId}")

    // This gives JSON.
    @Produces(MediaType.APPLICATION_JSON)

    // This deletes one workspace.
    public Response deleteworkspaceinformation(

            // This is workspace ID.
            @PathParam("workspaceId") String workspaceidentifier
    ) {

        // This checks all workspaces.
        for (MLWorkspace currentworkspaceinformation : DataStore.allworkspaceinformation) {

            // This checks workspace ID.
            if (currentworkspaceinformation.getWorkspaceidentifier()
                    .equals(workspaceidentifier)) {

                // This checks linked models.
                if (!currentworkspaceinformation.getLinkedmodelidentifiers().isEmpty()) {

                    // This gives workspace error.
                    throw new WorkspaceNotEmptyException(
                            "Workspace cannot be deleted because it still contains models."
                    );
                }

                // This removes the workspace.
                DataStore.allworkspaceinformation.remove(currentworkspaceinformation);

                // This gives delete message.
                return Response.ok(
                        new ErrorResponse("Workspace deleted successfully")
                ).build();
            }
        }

        // This gives not found.
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorResponse("Workspace not found"))
                .build();
    }
}