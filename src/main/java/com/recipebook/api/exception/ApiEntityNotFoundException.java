
package com.recipebook.api.exception;

/**
 * Exception that it thrown when app cannot find entity.
 */
@SuppressWarnings("serial")
public class ApiEntityNotFoundException extends RuntimeException {
    public ApiEntityNotFoundException(String entity, String id) {
        super("Cannot find [" + entity + "] with id [" + id + "].");
    }
}
