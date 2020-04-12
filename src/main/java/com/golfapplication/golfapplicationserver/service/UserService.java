package com.golfapplication.golfapplicationserver.service;

import com.golfapplication.golfapplicationserver.models.User;
import org.springframework.data.repository.CrudRepository;
public interface UserService extends CrudRepository<User, Integer> {
    Iterable<User>  findByFirstName(String firstName);
    Iterable<User>  findByLastName(String lastName);
    Iterable<User>  findByFirstNameAndLastName(String firstName,String lastName);

}
