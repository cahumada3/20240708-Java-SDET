package com.skillstorm.springaop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.springaop.models.Director;

@Repository
// JpaRepository<> is going to take in a Director object and then the Type of your ID (needs to be wrapper class)
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    
}
