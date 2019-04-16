package njuics.demos.petsalon.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.transform.Result;


@ControllerAdvice
@ResponseBody
public class notFoundAdvice{

    /*
    @ExceptionHandler(notFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notFoundHandler(notFoundException ex) {
        return ex.getMessage();
    }
    */
    @ExceptionHandler(notFoundException.class)
    public void handleException(Exception e) {
        e.printStackTrace();
    }
}