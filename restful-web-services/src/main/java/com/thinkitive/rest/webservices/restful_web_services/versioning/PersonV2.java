package com.thinkitive.rest.webservices.restful_web_services.versioning;

public class PersonV2 {
    private String name;
    private String lastname;

    public PersonV2(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
