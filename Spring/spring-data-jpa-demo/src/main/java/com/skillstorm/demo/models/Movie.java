package com.skillstorm.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

@Entity
@Table(name = "movies") // optional annotation if name of db table matches class name
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategies: IDENTITY or AUTO 
    private int id;

    @Column(length = 50)
    private String movieTitle;

    @Min(value = 0)
    @Max(value = 10)
    private int rating;

    // TODO3 Many-to-one mapping
    // Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)]
    @ManyToOne
    @JoinColumn(name = "director_id")
    @JsonManagedReference                   // prevent circular reference one of three ways: (jsonignore, jsonmanagemedreferenece, jsonproperty always as id)
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
        return "Movie [id=" + id + ", movieTitle=" + movieTitle + ", rating=" + rating + "]";
    }

    // don't add the foreign id column

    

}
