// This is the package name.
package com.mlops.api;

// This gets serializable.
import java.io.Serializable;

// This gets array list.
import java.util.ArrayList;

// This gets list.
import java.util.List;

// This keeps one workspace.
public class MLWorkspace implements Serializable {

    // This is the serial ID.
    private static final long serialVersionUID = 1L;

    // This is the workspace ID.
    private String workspaceidentifier;

    // This is the team name.
    private String workspaceteamname;

    // This is the storage size.
    private int storagequotagigabyte;

    // These are linked models.
    private List<String> linkedmodelidentifiers = new ArrayList<>();

    // This makes an empty workspace.
    public MLWorkspace() {
    }

    // This makes one workspace.
    public MLWorkspace(

            // This is the workspace ID.
            String workspaceidentifier,

            // This is the team name.
            String workspaceteamname,

            // This is the storage size.
            int storagequotagigabyte
    ) {

        // This sets the workspace ID.
        this.workspaceidentifier = workspaceidentifier;

        // This sets the team name.
        this.workspaceteamname = workspaceteamname;

        // This sets the storage size.
        this.storagequotagigabyte = storagequotagigabyte;
    }

    // This gets the workspace ID.
    public String getWorkspaceidentifier() {
        return workspaceidentifier;
    }

    // This gets the team name.
    public String getWorkspaceteamname() {
        return workspaceteamname;
    }

    // This gets the storage size.
    public int getStoragequotagigabyte() {
        return storagequotagigabyte;
    }

    // This gets linked models.
    public List<String> getLinkedmodelidentifiers() {
        return linkedmodelidentifiers;
    }

    // This sets the workspace ID.
    public void setWorkspaceidentifier(String workspaceidentifier) {

        // This is the workspace ID.
        this.workspaceidentifier = workspaceidentifier;
    }

    // This sets the team name.
    public void setWorkspaceteamname(String workspaceteamname) {

        // This is the team name.
        this.workspaceteamname = workspaceteamname;
    }

    // This sets the storage size.
    public void setStoragequotagigabyte(int storagequotagigabyte) {

        // This is the storage size.
        this.storagequotagigabyte = storagequotagigabyte;
    }

    // This sets linked models.
    public void setLinkedmodelidentifiers(List<String> linkedmodelidentifiers) {

        // These are linked models.
        this.linkedmodelidentifiers = linkedmodelidentifiers;
    }
}