package com.skillstorm.demo.dtos;

import org.springframework.beans.factory.annotation.Value;

/*
 * Reference: https://docs.spring.io/spring-data/jpa/reference/repositories/projections.html
 */
public interface MovieTitleRatingDto {

    /*
    Closed Projections:

    - Getter field names match original entity property names and values

     */

    String getMovieTitle();

    /*
    Open Projections:

    - Getters with computed values from oringal entity's properties allowed

    Example:
    
    -  Change 1-10 rating to 1-5 stars
    -  @Value contains a SpEL expression (Spring Expression Language)
       where target refers to the entity object 
         (implied when we use this interface as the return type of a repository method)
     */


    @Value("#{target.rating / 2}") 
    int getStarRating();

}
