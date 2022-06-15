
package com.recipebook.api.exception;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * <code>ControllerAdvice</code> class that is used to prepare
 * {@link ApiErrorResponse}.
 */
@ControllerAdvice
class ApiGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String ERR_MESSAGE = "message";

    @ExceptionHandler(ApiEntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiErrorResponse> handleNotFound(Exception e, WebRequest webRequest) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setTimestamp(LocalDateTime.now());
        apiErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        apiErrorResponse.setError(Collections.singletonMap(ERR_MESSAGE, e.getMessage()));
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({RecipeTitleDuplicateException.class, ApiMalformedRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrorResponse> handleBadRequest(Exception e, WebRequest webRequest) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setTimestamp(LocalDateTime.now());
        apiErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        apiErrorResponse.setError(Collections.singletonMap(ERR_MESSAGE, e.getMessage()));
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setTimestamp(LocalDateTime.now());
        apiErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        Map<String, String> errors = new HashMap<>();
        ((BindException) e).getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        apiErrorResponse.setError(errors);
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
