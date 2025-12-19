package com.thinkitive.security_awt_Oauth2.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
    Logger logger= LoggerFactory.getLogger(getClass());

    @GetMapping("/get")
    public String getData() {
        return "hello";
    }

}
