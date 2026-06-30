// This is the package name.
package com.mlops.api;

// This is one workspace error.
public class WorkspaceNotEmptyException extends RuntimeException {

    // This makes one error.
    public WorkspaceNotEmptyException(String errormessagetext) {

        // This sets the error message.
        super(errormessagetext);
    }
}