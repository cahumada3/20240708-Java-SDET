package com.skillstorm.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.demo.models.Director;
import com.skillstorm.demo.models.Movie;
/*
CrudRepository - has methods for CRUD operations

PagingAndSortingRepository - extends CRUD operations with ability to speicfy limit and offset of data returned

JpaRepository - extends PagingAndSortingRepository with more functionality like flushings the persistence context
 * 
 * 
 */
// @Repository         // used to be required to be recognized as a bean by Spring
public interface MovieRepository  extends JpaRepository<Movie, Integer>{


    @Query(value = "select m from Movie m ORDER BY rating LIMIT 3", nativeQuery = false)
    List<Movie> findTop3();

    List<Movie> findByDirector(Director director);


}
