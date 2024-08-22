package com.skillstorm.springaop.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillstorm.springaop.models.Movie;

import jakarta.transaction.Transactional;

/*
 * repositories talk to your database
 *      no business logic
 * 
 *      needs to be an interface that extends an existing repository class
 *          CrudRepository                  - crud operations
 *          PagingAndSortingRepository      - extends CrudRepository and includes methods for pagination and sorting
 *          JpaRepository                   - extends PagingAndSortingRepository plus lots of extras
 */

@Repository     // vs code may say that this is unnecessary - ignore VS Code and LEAVE the annotation
// JpaRepository<> is going to take in a Movie object and then the Type of your ID (needs to be wrapper class)
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    /*
     * the point of JPA is that you don't have to write basic queries anymore
     * 
     * 
     * jpa comes with many methods out of the box
     *      save, findAll, findById, delete, deleteByID, deleteAll, etc.
     * 
     * 
     * you can also create your own methods
     *      jpa will convert the name of your method into a JPQL query
     *      https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
     * 
     */
    
    public Optional<List<Movie>> findAllByRatingGreaterThanEqual(int minRating);

    /*
     * use @Query to write your own JPQL queries
     * 
     *  instead of @Param("var_name") and :var_name
     * 
     *  you can use ?1, ?2, ?3, etc.        - me: personally dont perfer it
     * 
     * 
     * need to use @Modifying for any insert, update, or delete queries
     *      if used, the method MUST return void or int/Integer
     */

    //@Query("update Movie m set m.title = ?2 where id = ?1")
    //so we can use : is used to reference a varaible name to a parameter
    @Query("update Movie m set m.title = :new_title where id = :movie_id")
    @Modifying  
    @Transactional      // for transaction management in spring boot
    public int updateMovieTitle(@Param("movie_id") int id, @Param("new_title") String newTitle);
    //public int updateMovieTitle(int id, String newTitle); //for wildcards? 1? 2?

    @Transactional
    @Modifying
    @Query("UPDATE Movie m SET m.title = :new_title, m.rating = :new_rating WHERE m.id = :movie_id")
    int updateMovie(@Param("movie_id") int id, @Param("new_title") String title, @Param("new_rating") int rating);

    /*
     * @TRANSACTIONAL
     *      make the method rollback if an error happens
     *      
     *      once a transaction starts, it cannot be stopped/interrupted (all at once)
     *      if an error occurs, roll everything back (all or none)
     */
}
