
package com.recipebook.api.exception;

/**
 * Exception that it thrown when (PUT) api endpoint is called with "entity id"
 * that is different from "entity id" contained within request body payload.
 */
@SuppressWarnings("serial")
public class ApiMalformedRequestException extends RuntimeException {

    public ApiMalformedRequestException(String entity) {
        super("Malformed PUT request. Please provide correct [" + entity + "] id.");
    }
}
