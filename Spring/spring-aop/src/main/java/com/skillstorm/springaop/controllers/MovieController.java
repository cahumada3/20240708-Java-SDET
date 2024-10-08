package com.skillstorm.springaop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.springaop.models.Movie;
import com.skillstorm.springaop.services.MovieService;

@RestController
@RequestMapping("/movies")
//@CrossOrigin("http://127.0.0.1:5500/")            //specifies who is allowed to make requests, it defaults to allowing all requests
 
@CrossOrigin("*")   //leaving it blank will allow all requests - not best for security     
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> findAllMovies() {
        List<Movie> movies = movieService.findAllMovies();

        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable int id) {
        Movie movie = movieService.findMovieById(id);
        return new ResponseEntity<Movie>(movie, HttpStatus.OK);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Movie>> findMoviesByRating(@PathVariable int rating) {

        List<Movie> movies = movieService.findMoviesByRating(rating);

        if(movies == null) {
            return ResponseEntity.noContent().build();
        }

        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);

    }

    @PostMapping("/movie") 
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        
        // insert the director that is provided with the movie - handle this in the service
        Movie newMovie = movieService.saveMovie(movie);
        return new ResponseEntity<Movie>(newMovie, HttpStatus.CREATED);
    }

    /*
     * updateMovie in postman using the Ids
     */
    // @PutMapping("/movie") 
    // public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        
    //     Movie newMovie = movieService.saveMovie(movie);
    //     return new ResponseEntity<Movie>(newMovie, HttpStatus.OK);
    // }

    // @PutMapping("/movie/updateTitle") 
    // public ResponseEntity<Integer> updateMovieTitle(@RequestBody Movie movie, @RequestParam String newTitle) {
        
    //     int updated = movieService.updateTitle(movie, newTitle);
    //     return new ResponseEntity<Integer>(updated, HttpStatus.OK);
    // }

    @PutMapping("/movie/updateMovie") 
    public ResponseEntity<Integer> updateMovie(@RequestBody Movie movie) {
        
        int updated = movieService.updateMovie(movie.getId(), movie.getTitle(), movie.getRating(), movie.getDirector());
        if (updated > 0) {
            //return new ResponseEntity<>(HttpStatus.OK);
            return new ResponseEntity<Integer>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/movie") 
    public ResponseEntity<Movie> deleteMovie(@RequestBody Movie movie) {
        
        movieService.deleteMovie(movie);
        return ResponseEntity.noContent().build();
    }
    
}
