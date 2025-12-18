package com.thinkitive.rest.webservices.restful_web_services.services;

import com.thinkitive.rest.webservices.restful_web_services.entity.User;
import com.thinkitive.rest.webservices.restful_web_services.exception.UserNotFoundException;
import com.thinkitive.rest.webservices.restful_web_services.repository.UserJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserJpaRepository userJpaRepository;
    public UserService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }


//this method returns all the users present inside the database
    public List<User> getUsers() {
        return userJpaRepository.findAll();

    }


//  this method returns user is saved or not

    public User saveUser(User user) {
        if (user == null ||
                user.getId() == null ||
                user.getName() == null ||
                user.getBirthDate() == null) {
            System.out.println(user);

            throw new IllegalArgumentException("Invalid user data");
        }
        System.out.println(user);
        return userJpaRepository.save(user);
    }

    public User findUserById(Integer id) {
        if (id !=null){
           return getUsers().stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
        }
        return null;

    }

    public void deleteUserById(Integer id) {
       User user= findUserById(id);
       if (user != null){
           userJpaRepository.delete(user);
       }
       else{
           throw new EntityNotFoundException("User id :"+id+" Not Found ");

       }


    }
}
