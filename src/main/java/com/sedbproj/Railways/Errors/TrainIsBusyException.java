package com.sedbproj.Railways.Errors;

public class TrainIsBusyException extends RuntimeException {
    public TrainIsBusyException(Integer id){
        super("The specified train: "+id+" is already busy");
    }
}
