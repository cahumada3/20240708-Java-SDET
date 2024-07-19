package com.skillstorm.demo.dtos;

import org.springframework.beans.factory.annotation.Value;

public interface DirectorNameDto {


    @Value("#{target.firstName + \" \" + target.lastName}") 
    int getFullName();
}
