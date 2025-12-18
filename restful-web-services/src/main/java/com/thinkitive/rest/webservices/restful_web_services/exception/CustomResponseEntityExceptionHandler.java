package com.thinkitive.rest.webservices.restful_web_services.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request)
    {
        DetailedException detailedException=new DetailedException(LocalDate.now(), ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(detailedException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request)
    {
        DetailedException detailedException=new DetailedException(LocalDate.now(), ex.getMessage(),request.getDescription(false));
        System.out.println("============================Exception================================");
        return new ResponseEntity(detailedException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<Object> handleEntityNotFoundException(Exception ex, WebRequest request)
    {
        DetailedException detailedException=new DetailedException(LocalDate.now(), ex.getMessage(),request.getDescription(false));
        System.out.println("============================Exception================================");
        return new ResponseEntity(detailedException, HttpStatus.NOT_FOUND);
    }

    @Override
//    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        DetailedException detailedException=new DetailedException(LocalDate.now(),
                "toatal Errors : "+ex.getErrorCount() +" "+ex.getFieldError().getDefaultMessage(),request.getDescription(false));

        return new ResponseEntity<>(detailedException,HttpStatus.BAD_REQUEST);
    }


}
