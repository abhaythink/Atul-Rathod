package com.thinkitive.rest.webservices.restful_web_services.controller;

import com.thinkitive.rest.webservices.restful_web_services.entity.User;
import com.thinkitive.rest.webservices.restful_web_services.exception.UserNotFoundException;
import com.thinkitive.rest.webservices.restful_web_services.services.UserService;
import jakarta.validation.Valid;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RestController
public class UserController {

    private UserService userService;
    private MessageSource messageSource;

    public UserController(UserService userService,MessageSource messageSource) {
        this.userService = userService;
        this.messageSource=messageSource;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> lu =userService.getUsers();
        if (!(lu.isEmpty())){
            return new ResponseEntity<>(lu, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(lu,HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@Valid  @RequestBody User user) {

            User savedUser = userService.saveUser(user);
            URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

            return ResponseEntity.created(location).body(savedUser);


    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Integer id)
    {
      User user=  userService.findUserById(id);
      if (user !=null){
//          EntityModel<User> uem=EntityModel.of(user);
//          WebMvcLinkBuilder link=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()),getUsers());
          return ResponseEntity.ok(userService.findUserById(id));
      }
        throw  new UserNotFoundException("User id "+id+" Not Found : ");
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/greet-internationalize")
    public String greet(){
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);

    }

}
//return new ArrayList<>(Arrays.asList(
//                new User(1, "Atul", LocalDate.now().minusYears(23)),
//        new User(2, "Rahul", LocalDate.now().minusYears(25)),
//        new User(3, "Neha", LocalDate.now().minusYears(22)),
//        new User(4, "Amit", LocalDate.now().minusYears(28))
//        ));