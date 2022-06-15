
package com.recipebook.api.exception;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Custom error response for all app API errors.
 */
class ApiErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private Map<String, String> error;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, String> getError() {
        return error;
    }

    public void setError(Map<String, String> error) {
        this.error = error;
    }
}
