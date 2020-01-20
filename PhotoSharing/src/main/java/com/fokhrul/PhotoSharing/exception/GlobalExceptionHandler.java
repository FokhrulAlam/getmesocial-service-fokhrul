package com.fokhrul.PhotoSharing.exception;

import com.fokhrul.PhotoSharing.exception.customeExceptionHandler.InvalidAlbumIdException;
import com.fokhrul.PhotoSharing.exception.customeExceptionHandler.InvalidPhotoIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * A class annotated with @ControllerAdvice, will by default apply to all classes
 * annotated with @Controller or @RestController annotation.
 * The code in this class is global to all other classes.
 */

@RestControllerAdvice
public class GlobalExceptionHandler  {

    /**
     * @ExceptionHandler annotation takes a bean of a class that extends Throwable.
     * Exception class handles all types of exceptions.
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest webRequest){
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now(),
                            "Exception did not match any of the exceptions handled in " +
                                    "GlobalExceptionHandler class.");
        return new ResponseEntity<>(apiErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerExceptions(NullPointerException exception,
                                                                   WebRequest webRequest)
    {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.NOT_FOUND, LocalDateTime.now(),
                                            "This is a null pointer exception");
        return new ResponseEntity<>(apiErrorMessage, HttpStatus.NOT_FOUND);
    }

    /**
     * Raise if the server can’t return any content conforming to the Accept headers of the client.
     * @param exception
     * @param webRequest
     * @return
     */
    @ExceptionHandler(value = {HttpMediaTypeNotSupportedException.class})
    public ResponseEntity<Object> handleNotAcceptableExceptions(HttpMediaTypeNotSupportedException exception,
                                                                WebRequest webRequest)
    {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.NOT_ACCEPTABLE, LocalDateTime.now(),
                            "Please check the Response Content Type");
        return new ResponseEntity<>(apiErrorMessage, HttpStatus.NOT_ACCEPTABLE);
    }


    /**
     * We will handle our custom exception "InvalidAlbumIdException"
     * @param exception
     * @param webRequest
     * @return
     */
    @ExceptionHandler(InvalidAlbumIdException.class)
    public ResponseEntity<Object> handleInvalidAlbumExceptions(InvalidAlbumIdException exception,
                                                               WebRequest webRequest)
    {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.NOT_FOUND, LocalDateTime.now(),
                                      "Album id does not exist.");
        return new ResponseEntity<>(apiErrorMessage, HttpStatus.NOT_FOUND);
    }


    /**
     * We will handle our custom exception "InvalidPhotoIdException"
     * @param exception
     * @param webRequest
     * @return
     */
    @ExceptionHandler(InvalidPhotoIdException.class)
    public ResponseEntity<Object> handleInvalidPhotoExceptions(InvalidPhotoIdException exception,
                                                               WebRequest webRequest)
    {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.NOT_FOUND, LocalDateTime.now(),
                "Photo id does not exist.");
        return new ResponseEntity<>(apiErrorMessage, HttpStatus.NOT_FOUND);
    }


    /**
     * Here we will handle the exceptions invoked by disobeying the validation rules of fields of model classes.
     * @param exception
     * @param webRequest
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidExceptions(
            MethodArgumentNotValidException exception, WebRequest webRequest)
    {
        Map<String, String> fieldMessage = new TreeMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            fieldMessage.put(fieldError.getField() , fieldError.getDefaultMessage());
        }
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.BAD_REQUEST, LocalDateTime.now(),
                "Model fields did not follow their validation rules.",
                fieldMessage);
        return new ResponseEntity<>(apiErrorMessage, HttpStatus.BAD_REQUEST);
    }

    /**
     * ConnectException occurs while trying to reach a URL which does not exist.
     * @param exception
     * @param webRequest
     * @return
     */
//    @ExceptionHandler(NoHandlerFoundException.class)
//    public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException exception,
//                                                                WebRequest webRequest)
//    {
//        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.NOT_FOUND, LocalDateTime.now(),
//                "No such URL found. Please check the URL.");
//        return new ResponseEntity<>(apiErrorMessage, HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler(ValidationException.class)
//
//    public ResponseEntity<Object> handleValidationException(ValidationException exception, WebRequest webRequest)
//    {
//        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.BAD_REQUEST, LocalDateTime.now(),
//                "Model fields did not follow validation rules", exception.getMessage());
//        return new ResponseEntity<>(apiErrorMessage, HttpStatus.BAD_REQUEST);
//    }

}
