// This is the package name.
package com.mlops.api;

// This gets array list.
import java.util.ArrayList;

// This gets list.
import java.util.List;

// This gets UUID.
import java.util.UUID;

// This gets GET.
import javax.ws.rs.GET;

// This gets POST.
import javax.ws.rs.POST;

// This gets consumes.
import javax.ws.rs.Consumes;

// This gets produces.
import javax.ws.rs.Produces;

// This gets media type.
import javax.ws.rs.core.MediaType;

// This gets response.
import javax.ws.rs.core.Response;

// This controls model metrics.
public class EvaluationMetricResource {

    // This is the model ID.
    private String selectedmodelidentifier;

    // This makes metric resource.
    public EvaluationMetricResource(String selectedmodelidentifier) {

        // This is the model ID.
        this.selectedmodelidentifier = selectedmodelidentifier;
    }

    // This is GET.
    @GET

    // This gives JSON.
    @Produces(MediaType.APPLICATION_JSON)

    // This gets all metrics.
    public Response getallmetrics() {

        // This is the model.
        MLModel selectedmodelinformation = findmodelinformation(selectedmodelidentifier);

        // This checks the model.
        if (selectedmodelinformation == null) {

            // This gives not found.
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse("Model not found"))
                    .build();
        }

        // These are model metrics.
        List<EvaluationMetric> allmodelmetrics =
                DataStore.allmodelmetrics.get(selectedmodelidentifier);

        // This checks metrics.
        if (allmodelmetrics == null) {

            // This makes empty metrics.
            allmodelmetrics = new ArrayList<>();

            // This saves empty metrics.
            DataStore.allmodelmetrics.put(selectedmodelidentifier, allmodelmetrics);
        }

        // This gives all metrics.
        return Response.ok(allmodelmetrics).build();
    }

    // This is POST.
    @POST

    // This reads JSON.
    @Consumes(MediaType.APPLICATION_JSON)

    // This gives JSON.
    @Produces(MediaType.APPLICATION_JSON)

    // This adds one metric.
    public Response addnewmetric(EvaluationMetric metricinformation) {

        // This is the model.
        MLModel selectedmodelinformation = findmodelinformation(selectedmodelidentifier);

        // This checks the model.
        if (selectedmodelinformation == null) {

            // This gives not found.
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse("Model not found"))
                    .build();
        }

        // This checks old model.
        if ("DEPRECATED".equalsIgnoreCase(selectedmodelinformation.getCurrentmodelstatus())) {

            // This gives an error.
            throw new ModelDeprecatedException("Deprecated models cannot accept new metrics.");
        }

        // This checks metric ID.
        if (metricinformation.getMetricidentifier() == null
                || metricinformation.getMetricidentifier().isEmpty()) {

            // This sets metric ID.
            metricinformation.setMetricidentifier(
                    "metric-" + UUID.randomUUID().toString()
            );
        }

        // This checks time.
        if (metricinformation.getMeasurementtimestamp() == 0) {

            // This sets time.
            metricinformation.setMeasurementtimestamp(System.currentTimeMillis());
        }

        // These are model metrics.
        List<EvaluationMetric> allmodelmetrics =
                DataStore.allmodelmetrics.get(selectedmodelidentifier);

        // This checks metrics.
        if (allmodelmetrics == null) {

            // This makes empty metrics.
            allmodelmetrics = new ArrayList<>();

            // This saves empty metrics.
            DataStore.allmodelmetrics.put(selectedmodelidentifier, allmodelmetrics);
        }

        // This adds the metric.
        allmodelmetrics.add(metricinformation);

        // This sets latest score.
        selectedmodelinformation.setLatestaccuracyscore(
                metricinformation.getModelaccuracyscore()
        );

        // This gives created metric.
        return Response.status(Response.Status.CREATED)
                .entity(metricinformation)
                .build();
    }

    // This finds one model.
    private MLModel findmodelinformation(String selectedmodelidentifier) {

        // This checks all models.
        for (MLModel currentmodelinformation : DataStore.allmodelinformation) {

            // This checks model ID.
            if (currentmodelinformation.getModelidentifier().equals(selectedmodelidentifier)) {

                // This gives the model.
                return currentmodelinformation;
            }
        }

        // This gives no model.
        return null;
    }
}