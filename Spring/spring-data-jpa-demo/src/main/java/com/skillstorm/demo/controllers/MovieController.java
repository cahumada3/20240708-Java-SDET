package com.skillstorm.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.demo.models.Movie;
import com.skillstorm.demo.services.MovieService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
public class MovieController {

    private final Logger logger = LoggerFactory.getLogger(MovieController.class);


    private MovieService service;

    // use dependency injection to get an instance of the MovieRepository
    // @Autowired         // not required when there is only one constructor
    public MovieController(MovieService service) {
        this.service = service;
    }

    // @GetMapping("/hello")
    // public String helloWorld() {
    //     return "Hello";
    // }

    @GetMapping
    public Iterable<Movie> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable int id) {
        Optional<Movie> movie = service.findById(id);
        if (movie.isPresent())
            return ResponseEntity.ok(movie.get());
        else 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
     * POST Expects JSON in format (note director cannot be null and must exist already)
{
    "movieTitle": "Gladiator",
    "rating": 10,
    "director": {
        "id": 4
    }
}
     */
    @PostMapping()// POST http://localhost:8080/movies
    @ResponseStatus(code = HttpStatus.CREATED)
    public Movie create(@Valid @RequestBody Movie movie) {
        logger.debug("====================================");
        logger.debug("POST request to /movies with Movie of " + movie);
        return service.save(movie);
    }

    @PutMapping("/{id}")
    public void putMethodName(@PathVariable int id, @RequestBody Movie entity) {

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }

}
