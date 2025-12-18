package com.thinkitive.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringControllers {

    @GetMapping("/sfilter")
    public MappingJacksonValue getPerson(){
        Person person=new Person("filed1","field2","field3");
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(person);
        PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filed1","field3");
        FilterProvider filters =new SimpleFilterProvider().addFilter("SomeFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
    @GetMapping("/sfilters")
    public List<Person> getAllPersons(){
        return new ArrayList<>(Arrays.asList(new Person("filed1","field2","field3"),new Person("filed1","field2","field3"),new Person("filed1","field2","field3")));
    }
}
