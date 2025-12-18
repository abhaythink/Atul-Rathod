package com.thinkitive.rest.webservices.restful_web_services.repository;

import com.thinkitive.rest.webservices.restful_web_services.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User,Integer> {
}
