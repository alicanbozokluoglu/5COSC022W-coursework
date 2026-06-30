// This is the package name.
package com.mlops.api;

// This keeps one error message.
public class ErrorResponse {

    // This is the error message.
    private String errormessagetext;

    // This makes an empty error.
    public ErrorResponse() {
    }

    // This makes one error.
    public ErrorResponse(String errormessagetext) {

        // This sets the error message.
        this.errormessagetext = errormessagetext;
    }

    // This gets the error message.
    public String getErrormessagetext() {
        return errormessagetext;
    }

    // This sets the error message.
    public void setErrormessagetext(String errormessagetext) {

        // This is the error message.
        this.errormessagetext = errormessagetext;
    }
}