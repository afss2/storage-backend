package com.storage.exceptions;

public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException() {
        super();
    }
    public RecipeNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RecipeNotFoundException(String msg) {
        super(msg);
    }

    public RecipeNotFoundException(Throwable cause) {
        super(cause);
    }

}
