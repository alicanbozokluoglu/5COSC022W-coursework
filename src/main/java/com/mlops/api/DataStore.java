// This is the package name.
package com.mlops.api;

// This gets array list.
import java.util.ArrayList;

// This gets hash map.
import java.util.HashMap;

// This gets list.
import java.util.List;

// This gets map.
import java.util.Map;

// This keeps all data.
public class DataStore {

    // These are all workspaces.
    public static List<MLWorkspace> allworkspaceinformation = new ArrayList<>();

    // These are all models.
    public static List<MLModel> allmodelinformation = new ArrayList<>();

    // These are all model metrics.
    public static Map<String, List<EvaluationMetric>> allmodelmetrics = new HashMap<>();

    // This adds start data.
    static {

        // This is the first workspace.
        MLWorkspace firstworkspaceinformation = new MLWorkspace("ws-001", "Computer Vision Lab", 500);

        // This is the second workspace.
        MLWorkspace secondworkspaceinformation = new MLWorkspace("ws-002", "NLP Research Team", 300);

        // This adds the first workspace.
        allworkspaceinformation.add(firstworkspaceinformation);

        // This adds the second workspace.
        allworkspaceinformation.add(secondworkspaceinformation);

        // This is the first model.
        MLModel firstmodelinformation = new MLModel("model-001", "TensorFlow", "DEPLOYED", 0.91, "ws-001");

        // This is the second model.
        MLModel secondmodelinformation = new MLModel("model-002", "PyTorch", "TRAINING", 0.84, "ws-002");

        // This adds the first model.
        allmodelinformation.add(firstmodelinformation);

        // This adds the second model.
        allmodelinformation.add(secondmodelinformation);

        // This links the first model.
        firstworkspaceinformation.getLinkedmodelidentifiers().add("model-001");

        // This links the second model.
        secondworkspaceinformation.getLinkedmodelidentifiers().add("model-002");

        // This makes metrics for model one.
        allmodelmetrics.put("model-001", new ArrayList<>());

        // This makes metrics for model two.
        allmodelmetrics.put("model-002", new ArrayList<>());
    }
}