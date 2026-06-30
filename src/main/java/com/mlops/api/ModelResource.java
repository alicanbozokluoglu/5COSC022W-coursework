// This is the package name.
package com.mlops.api;

// This gets array list.
import java.util.ArrayList;

// This gets list.
import java.util.List;

// This gets UUID.
import java.util.UUID;

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

// This gets query param.
import javax.ws.rs.QueryParam;

// This gets produces.
import javax.ws.rs.Produces;

// This gets media type.
import javax.ws.rs.core.MediaType;

// This gets response.
import javax.ws.rs.core.Response;

// This is model resource.
@Path("/models")
public class ModelResource {

    // This is GET.
    @GET

    // This gives JSON.
    @Produces(MediaType.APPLICATION_JSON)

    // This gets all models.
    public List<MLModel> getallmodels(

            // This is model status.
            @QueryParam("status") String requestedmodelstatus
    ) {

        // This checks status.
        if (requestedmodelstatus == null || requestedmodelstatus.isEmpty()) {

            // This gives all models.
            return DataStore.allmodelinformation;
        }

        // These are filtered models.
        List<MLModel> filteredmodelinformation = new ArrayList<>();

        // This checks all models.
        for (MLModel currentmodelinformation : DataStore.allmodelinformation) {

            // This checks model status.
            if (currentmodelinformation.getCurrentmodelstatus()
                    .equalsIgnoreCase(requestedmodelstatus)) {

                // This adds the model.
                filteredmodelinformation.add(currentmodelinformation);
            }
        }

        // This gives filtered models.
        return filteredmodelinformation;
    }

    // This is POST.
    @POST

    // This reads JSON.
    @Consumes(MediaType.APPLICATION_JSON)

    // This gives JSON.
    @Produces(MediaType.APPLICATION_JSON)

    // This makes a new model.
    public Response createnewmodel(MLModel newmodelinformation) {

        // This is the linked workspace.
        MLWorkspace linkedworkspaceinformation =
                findlinkedworkspace(newmodelinformation.getLinkedworkspaceidentifier());

        // This checks the workspace.
        if (linkedworkspaceinformation == null) {

            // This gives workspace error.
            throw new LinkedWorkspaceNotFoundException(
                    "Linked workspace does not exist."
            );
        }

        // This checks model ID.
        if (newmodelinformation.getModelidentifier() == null
                || newmodelinformation.getModelidentifier().isEmpty()) {

            // This sets model ID.
            newmodelinformation.setModelidentifier(
                    "model-" + UUID.randomUUID().toString()
            );
        }

        // This adds the model.
        DataStore.allmodelinformation.add(newmodelinformation);

        // This links the model.
        linkedworkspaceinformation.getLinkedmodelidentifiers()
                .add(newmodelinformation.getModelidentifier());

        // This makes model metrics.
        DataStore.allmodelmetrics.put(
                newmodelinformation.getModelidentifier(),
                new ArrayList<>()
        );

        // This gives created model.
        return Response.status(Response.Status.CREATED)
                .entity(newmodelinformation)
                .build();
    }

    // This is GET.
    @GET

    // This sets the path.
    @Path("/{modelId}")

    // This gives JSON.
    @Produces(MediaType.APPLICATION_JSON)

    // This gets one model.
    public Response getmodelbyidentifier(

            // This is model ID.
            @PathParam("modelId") String modelidentifier
    ) {

        // This checks all models.
        for (MLModel currentmodelinformation : DataStore.allmodelinformation) {

            // This checks model ID.
            if (currentmodelinformation.getModelidentifier()
                    .equals(modelidentifier)) {

                // This gives the model.
                return Response.ok(currentmodelinformation).build();
            }
        }

        // This gives not found.
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorResponse("Model not found"))
                .build();
    }

    // This is DELETE.
    @DELETE

    // This sets the path.
    @Path("/{modelId}")

    // This gives JSON.
    @Produces(MediaType.APPLICATION_JSON)

    // This deletes one model.
    public Response deletemodelinformation(

            // This is model ID.
            @PathParam("modelId") String modelidentifier
    ) {

        // This is the selected model.
        MLModel selectedmodelinformation = null;

        // This checks all models.
        for (MLModel currentmodelinformation : DataStore.allmodelinformation) {

            // This checks model ID.
            if (currentmodelinformation.getModelidentifier()
                    .equals(modelidentifier)) {

                // This is the selected model.
                selectedmodelinformation = currentmodelinformation;

                // This stops the loop.
                break;
            }
        }

        // This checks the model.
        if (selectedmodelinformation == null) {

            // This gives not found.
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse("Model not found"))
                    .build();
        }

        // This removes the model.
        DataStore.allmodelinformation.remove(selectedmodelinformation);

        // This removes model metrics.
        DataStore.allmodelmetrics.remove(modelidentifier);

        // This is the linked workspace.
        MLWorkspace linkedworkspaceinformation =
                findlinkedworkspace(
                        selectedmodelinformation.getLinkedworkspaceidentifier()
                );

        // This checks the workspace.
        if (linkedworkspaceinformation != null) {

            // This removes the model link.
            linkedworkspaceinformation.getLinkedmodelidentifiers()
                    .remove(modelidentifier);
        }

        // This gives delete message.
        return Response.ok(
                new ErrorResponse("Model deleted successfully")
        ).build();
    }

    // This sets metrics path.
    @Path("/{modelId}/metrics")

    // This gets metric resource.
    public EvaluationMetricResource getevaluationmetricresource(

            // This is model ID.
            @PathParam("modelId") String modelidentifier
    ) {

        // This gives metric resource.
        return new EvaluationMetricResource(modelidentifier);
    }

    // This finds linked workspace.
    private MLWorkspace findlinkedworkspace(String workspaceidentifier) {

        // This checks all workspaces.
        for (MLWorkspace currentworkspaceinformation : DataStore.allworkspaceinformation) {

            // This checks workspace ID.
            if (currentworkspaceinformation.getWorkspaceidentifier()
                    .equals(workspaceidentifier)) {

                // This gives the workspace.
                return currentworkspaceinformation;
            }
        }

        // This gives no workspace.
        return null;
    }
}