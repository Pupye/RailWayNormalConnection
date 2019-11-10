package com.sedbproj.Railways.Errors;

public class DuplicatedBookException extends RuntimeException {
    public DuplicatedBookException(){
        super("You can not book the seat that is already booked");
    }
}
