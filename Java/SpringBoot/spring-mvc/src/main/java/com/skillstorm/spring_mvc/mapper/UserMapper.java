package com.skillstorm.spring_mvc.mapper;

import org.springframework.stereotype.Component;

import com.skillstorm.spring_mvc.dtos.UserDto;
import com.skillstorm.spring_mvc.models.User;

/**
 * convert UserDto to User and vice versa
 */

@Component
public class UserMapper {

    public User toUser(UserDto dto) {
        return new User(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail());
    }

    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }
    
}
