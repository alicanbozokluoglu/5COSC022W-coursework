// This is the package name.
package com.mlops.api;

// This is one model error.
public class ModelDeprecatedException extends RuntimeException {

    // This makes one error.
    public ModelDeprecatedException(String errormessagetext) {

        // This sets the error message.
        super(errormessagetext);
    }
}