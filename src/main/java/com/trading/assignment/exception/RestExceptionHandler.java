package com.trading.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RestController
public class RestExceptionHandler {

    @ExceptionHandler(IsoNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExResponse isoNotFound(HttpServletRequest req, IsoNotFoundException ex) {
        String errorURL = req.getRequestURL().toString();

        return new ExResponse(errorURL, ex.getErrorMessage(), HttpStatus.NOT_FOUND.toString());
    }
}
