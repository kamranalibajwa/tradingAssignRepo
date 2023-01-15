package com.trading.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RestController
public class RestExceptionHandler {


    @ExceptionHandler(InvalidParamException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExResponse invalidParams(HttpServletRequest req, InvalidParamException ex) {
        String errorURL = req.getRequestURL().toString();

        return new ExResponse(errorURL, ex.getErrorMessage(), HttpStatus.BAD_REQUEST.toString());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExResponse notFound(HttpServletRequest req, NotFoundException ex) {
        String errorURL = req.getRequestURL().toString();

        return new ExResponse(errorURL, ex.getErrorMessage(), HttpStatus.NOT_FOUND.toString());
    }

    @ExceptionHandler(IsoNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExResponse isoNotFound(HttpServletRequest req, IsoNotFoundException ex) {
        String errorURL = req.getRequestURL().toString();

        return new ExResponse(errorURL, ex.getErrorMessage(), HttpStatus.NOT_FOUND.toString());
    }
}
