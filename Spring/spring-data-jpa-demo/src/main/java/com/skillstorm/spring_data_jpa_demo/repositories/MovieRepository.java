package com.skillstorm.spring_data_jpa_demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.spring_data_jpa_demo.models.Movie;
/*
CrudRepository - has methods for CRUD operations

PagingAndSortingRepository - extends CRUD operations with ability to speicfy limit and offset of data returned

JpaRepository - extends PagingAndSortingRepository with more functionality like flushings the persistence context
 * 
 * 
 */
// @Repository         // used to be required to be recognized as a bean by Spring
public interface MovieRepository  extends CrudRepository<Movie, Integer>{

}
