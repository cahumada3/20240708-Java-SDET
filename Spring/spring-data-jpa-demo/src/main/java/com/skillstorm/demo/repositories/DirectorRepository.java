package com.skillstorm.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.demo.models.Director;

public interface DirectorRepository extends JpaRepository<Director, Integer> {

}
