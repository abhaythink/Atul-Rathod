package com.thinkitive.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypesOfVersioning  {

    // 1️⃣ URI Versioning
    @GetMapping("/v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Atul");
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2("Atul", "Rathod");
    }

    // 2️⃣ Request Parameter Versioning
    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getPersonParamV1() {
        return new PersonV1("Atul");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getPersonParamV2() {
        return new PersonV2("Atul", "Rathod");
    }

    // 3️⃣ Header Versioning
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonHeaderV1() {
        return new PersonV1("Atul");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonHeaderV2() {
        return new PersonV2("Atul", "Rathod");
    }
}