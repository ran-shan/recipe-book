
package com.recipebook.api.exception;

import com.recipebook.api.entity.Recipe;

/**
 * Exception that it thrown when app is trying to persist a {@link Recipe} with
 * the title that is same as one in database.
 */
@SuppressWarnings("serial")
public class RecipeTitleDuplicateException extends RuntimeException {

    public RecipeTitleDuplicateException(Exception e) {
        super("There cannot be two recipes with the same title.");
    }
}
