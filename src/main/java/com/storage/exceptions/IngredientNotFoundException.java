package com.storage.exceptions;

public class IngredientNotFoundException extends RuntimeException {

    public IngredientNotFoundException() {
        super();
    }
    public IngredientNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public IngredientNotFoundException(String msg) {
        super(msg);
    }

    public IngredientNotFoundException(Throwable cause) {
        super(cause);
    }

}
