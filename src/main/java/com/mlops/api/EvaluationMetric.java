// This is the package name.
package com.mlops.api;

// This keeps one metric.
public class EvaluationMetric {

    // This is the metric ID.
    private String metricidentifier;

    // This is the time.
    private long measurementtimestamp;

    // This is the accuracy score.
    private double modelaccuracyscore;

    // This makes an empty metric.
    public EvaluationMetric() {
    }

    // This makes one metric.
    public EvaluationMetric(

            // This is the metric ID.
            String metricidentifier,

            // This is the time.
            long measurementtimestamp,

            // This is the accuracy score.
            double modelaccuracyscore
    ) {

        // This sets the metric ID.
        this.metricidentifier = metricidentifier;

        // This sets the time.
        this.measurementtimestamp = measurementtimestamp;

        // This sets the accuracy score.
        this.modelaccuracyscore = modelaccuracyscore;
    }

    // This gets the metric ID.
    public String getMetricidentifier() {
        return metricidentifier;
    }

    // This gets the time.
    public long getMeasurementtimestamp() {
        return measurementtimestamp;
    }

    // This gets the accuracy score.
    public double getModelaccuracyscore() {
        return modelaccuracyscore;
    }

    // This sets the metric ID.
    public void setMetricidentifier(String metricidentifier) {

        // This is the metric ID.
        this.metricidentifier = metricidentifier;
    }

    // This sets the time.
    public void setMeasurementtimestamp(long measurementtimestamp) {

        // This is the time.
        this.measurementtimestamp = measurementtimestamp;
    }

    // This sets the accuracy score.
    public void setModelaccuracyscore(double modelaccuracyscore) {

        // This is the accuracy score.
        this.modelaccuracyscore = modelaccuracyscore;
    }
}