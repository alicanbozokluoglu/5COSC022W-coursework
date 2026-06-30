// This is the package name.
package com.mlops.api;

// This is one workspace error.
public class LinkedWorkspaceNotFoundException extends RuntimeException {

    // This makes one error.
    public LinkedWorkspaceNotFoundException(String errormessagetext) {

        // This sets the error message.
        super(errormessagetext);
    }
}