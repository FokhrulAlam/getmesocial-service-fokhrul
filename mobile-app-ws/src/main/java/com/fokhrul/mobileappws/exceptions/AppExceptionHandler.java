package com.fokhrul.mobileappws.exceptions;

import com.fokhrul.mobileappws.ui.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * To make this class able to handle all the exceptions,
 * @ControllerAdvice annotation is neede.
 * This class should extend ResponseEntityExceptionHandler
 */
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * The method that handles the exceptions should be annotated with the follwoing
     * @ExceptionHandler
     */
    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
//        return new ResponseEntity<>(
//                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){

        String errorMessageDescription = ex.getLocalizedMessage();
        if (errorMessageDescription == null) errorMessageDescription = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
