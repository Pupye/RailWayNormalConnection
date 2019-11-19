package com.sedbproj.Railways.Errors;

public class RouteNotFoundException  extends RuntimeException {
    public RouteNotFoundException() {
        super("There is no route on this date");
    }
}
