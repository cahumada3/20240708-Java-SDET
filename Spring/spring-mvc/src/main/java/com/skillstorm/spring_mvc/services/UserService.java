package com.skillstorm.spring_mvc.services;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spring_mvc.dtos.UserDto;
import com.skillstorm.spring_mvc.mapper.UserMapper;
import com.skillstorm.spring_mvc.models.User;

/**
 * @Service - is where you will do all the business logic for your controller and repositores
 */

@Service    // stereotype annotation for @Component
public class UserService {

    @Autowired
    UserMapper mapper;

    public List<UserDto> findAllUsersDto() {
        List<User> users = new LinkedList<>();
        users.add(new User(0, "Caroline", "Ahumada", "cahumada@skillstorm.com", "password123"));
        users.add(new User(1, "Branden", "Arms", "barms@skillstorm.com", "password123!"));
        users.add(new User(2, "Kendall", "Budd", "kbudd@skillstorm.com", "verystrongpassword123"));
        users.add(new User(3, "Andy", "Zheng", "azheng@skillstorm.com", "password123"));
        users.add(new User(4, "Aaron", "Huggins", "ahuggins@skillstorm.com", "password123"));

        /**
         * converting List<User> to Stream<User>, then converting Stream<User> to Stream<UserDto>, 
         * lastly converting Stream<UserDto> to List<UserDto>
         */
        List<UserDto> userDtos = users.stream().map(mapper::toDto).collect(Collectors.toList());
        //List<UserDto> userDtos = users.stream().map(mapper::toDto).toList();

        return userDtos;
    }

    public List<User> findAllUsers() {
        List<User> users = new LinkedList<>();

        users.add(new User(0, "Caroline", "Ahumada", "cahumada@skillstorm.com", "password123"));
        users.add(new User(1, "Branden", "Arms", "barms@skillstorm.com", "password123!"));
        users.add(new User(2, "Kendall", "Budd", "kbudd@skillstorm.com", "verystrongpassword123"));
        users.add(new User(3, "Andy", "Zheng", "azheng@skillstorm.com", "password123"));
        users.add(new User(4, "Aaron", "Huggins", "ahuggins@skillstorm.com", "password123"));

        return users; 
    }

    public List<User> findUsersByFirstName(String name) {
        List<User> users = new LinkedList<>();

        users.add(new User(0, name, "Ahumada", "cahumada@skillstorm.com", "password123"));
        users.add(new User(1, name, "Arms", "barms@skillstorm.com", "password123!"));
        users.add(new User(2, name, "Budd", "kbudd@skillstorm.com", "verystrongpassword123"));

        return users;
    }

    public User findById(long id) {
        return new User(id, "Kendall", "Budd", "kbudd@skillstorm.com", "verystrongpassword123");
    }

    public User createUser(User user) {
        user.setId(10);
        return user;
    }

    public User updateUser(long id, User user) {
        user.setId(id);
        return user;
    }

    // public User deleteUser(long id, User user) {
    //     return user;
    // }

    public User deleteUser(long id) {
        return new User(id, "Kendall", "Budd", "kbudd@skillstorm.com", "verystrongpassword123");
    }
    
}
