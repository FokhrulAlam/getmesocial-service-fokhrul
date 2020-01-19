package com.fokhrul.PhotoSharing.exception;

import com.fokhrul.PhotoSharing.exception.customeExceptionHandler.InvalidAlbumIdException;
import com.fokhrul.PhotoSharing.exception.customeExceptionHandler.InvalidPhotoIdException;
import com.fokhrul.PhotoSharing.exception.customeExceptionHandler.ResourceNotFoundException;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * A class annotated with @ControllerAdvice, will by default apply to all classes
 * annotated with @Controller or @RestController annotation.
 * The code in this class is global to all other classes.
 */

@ControllerAdvice
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
                                            exception.toString());
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

    @ExceptionHandler(InvalidAlbumIdException.class)
    public ResponseEntity<Object> handleInvalidAlbumExceptions(InvalidAlbumIdException exception,
                                                               WebRequest webRequest)
    {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.NOT_FOUND, LocalDateTime.now(),
                                      "Album id does not exist.");
        return new ResponseEntity<>(apiErrorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPhotoIdException.class)
    public ResponseEntity<Object> handleInvalidPhotoExceptions(InvalidPhotoIdException exception,
                                                               WebRequest webRequest)
    {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.NOT_FOUND, LocalDateTime.now(),
                "Photo id does not exist.");
        return new ResponseEntity<>(apiErrorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidExceptions(
            MethodArgumentNotValidException exception, WebRequest webRequest)
    {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.BAD_REQUEST, LocalDateTime.now(),
                "Model fields did not follow their validation rules.");
        return new ResponseEntity<>(apiErrorMessage, HttpStatus.BAD_REQUEST);
    }

}
