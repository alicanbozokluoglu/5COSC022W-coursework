// This is the package name.
package com.mlops.api;

// This gets serializable.
import java.io.Serializable;

// This keeps one model.
public class MLModel implements Serializable {

    // This is the serial ID.
    private static final long serialVersionUID = 1L;

    // This is the model ID.
    private String modelidentifier;

    // This is the framework name.
    private String frameworkname;

    // This is the model status.
    private String currentmodelstatus;

    // This is the accuracy score.
    private double latestaccuracyscore;

    // This is the workspace ID.
    private String linkedworkspaceidentifier;

    // This makes an empty model.
    public MLModel() {
    }

    // This makes one model.
    public MLModel(

            // This is the model ID.
            String modelidentifier,

            // This is the framework name.
            String frameworkname,

            // This is the model status.
            String currentmodelstatus,

            // This is the accuracy score.
            double latestaccuracyscore,

            // This is the workspace ID.
            String linkedworkspaceidentifier
    ) {

        // This sets the model ID.
        this.modelidentifier = modelidentifier;

        // This sets the framework name.
        this.frameworkname = frameworkname;

        // This sets the model status.
        this.currentmodelstatus = currentmodelstatus;

        // This sets the accuracy score.
        this.latestaccuracyscore = latestaccuracyscore;

        // This sets the workspace ID.
        this.linkedworkspaceidentifier = linkedworkspaceidentifier;
    }

    // This gets the model ID.
    public String getModelidentifier() {
        return modelidentifier;
    }

    // This gets the framework name.
    public String getFrameworkname() {
        return frameworkname;
    }

    // This gets the model status.
    public String getCurrentmodelstatus() {
        return currentmodelstatus;
    }

    // This gets the accuracy score.
    public double getLatestaccuracyscore() {
        return latestaccuracyscore;
    }

    // This gets the workspace ID.
    public String getLinkedworkspaceidentifier() {
        return linkedworkspaceidentifier;
    }

    // This sets the model ID.
    public void setModelidentifier(String modelidentifier) {

        // This is the model ID.
        this.modelidentifier = modelidentifier;
    }

    // This sets the framework name.
    public void setFrameworkname(String frameworkname) {

        // This is the framework name.
        this.frameworkname = frameworkname;
    }

    // This sets the model status.
    public void setCurrentmodelstatus(String currentmodelstatus) {

        // This is the model status.
        this.currentmodelstatus = currentmodelstatus;
    }

    // This sets the accuracy score.
    public void setLatestaccuracyscore(double latestaccuracyscore) {

        // This is the accuracy score.
        this.latestaccuracyscore = latestaccuracyscore;
    }

    // This sets the workspace ID.
    public void setLinkedworkspaceidentifier(String linkedworkspaceidentifier) {

        // This is the workspace ID.
        this.linkedworkspaceidentifier = linkedworkspaceidentifier;
    }
}