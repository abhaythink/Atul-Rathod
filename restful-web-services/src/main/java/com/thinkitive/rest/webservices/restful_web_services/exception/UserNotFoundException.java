package com.thinkitive.rest.webservices.restful_web_services.exception;


public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
