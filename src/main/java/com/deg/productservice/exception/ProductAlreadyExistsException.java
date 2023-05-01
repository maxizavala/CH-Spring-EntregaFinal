package com.deg.productservice.exception;

public class ProductAlreadyExistsException extends Exception {
    public ProductAlreadyExistsException(String msj) {
        super(msj);
    }
}
