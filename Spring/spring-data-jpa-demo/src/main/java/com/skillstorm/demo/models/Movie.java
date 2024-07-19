package com.skillstorm.demo.models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "movies") // optional annotation if name of db table matches class name
public class Movie {

    /*
     Validation checks:

     Depenedency for Validation we added give us the ability to use built-in validators instead of writing our own

     @Min  - only for numeric types
     @Max - only for numeric types
     @NotNull
     @NotBlank - only for strings

     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategies: IDENTITY or AUTO 
    private int id;

    @Column(length = 50)
    private String movieTitle;

    @Min(value = 0)
    @Max(value = 10)
    private int rating;

    /* 
    // @Many-to-one mapping
    Circular reference:
    
    Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)]

    Solution:

    Mark the list @JsonIgnore
    or
    Mark the list @JsonBackReference
    or
    Mark the Direcgtor class as having a customized way for Jackson to seralize it and add
     @JsonIdentityReference(alwaysAsId = true)                 


    */
    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    @NotNull
    @JoinColumn(name = "director_id")
    @JsonIdentityReference(alwaysAsId= true)
    private Director director;

    // do not do 
    // private int directorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", movieTitle=" + movieTitle + ", rating=" + rating + ", director " + (director == null ? null : director.getFirstName()) + " " + (director == null ? null : director.getLastName()) + "]";
    }

    // don't add the foreign id column

    

}
