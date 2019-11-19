package com.sedbproj.Railways.Errors.ExHandler;

import com.sedbproj.Railways.Errors.DuplicatedBookException;
import com.sedbproj.Railways.Errors.RouteNotFoundException;
import com.sedbproj.Railways.Errors.TrainIsBusyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({DuplicatedBookException.class, TrainIsBusyException.class})
    public void springHandleBadRequest(HttpServletResponse response) throws IOException{
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(RouteNotFoundException.class)
    public  void springNotFoundError(HttpServletResponse response) throws   IOException{
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}
