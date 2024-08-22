package com.skillstorm.springaop.controllers;

import java.util.List;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.skillstorm.springaop.models.Movie;
import com.skillstorm.springaop.services.MovieService;

public class MovieControllerTest {
    /**
     * Mockito
     *     - Java-based framework used for creating mock objects in unit tests
     *     - Allows for developers to isolate behavior of the class being tested by simulating
     *       the behavior of its dependencies
     * 
     *     Mocking
     *      - a process of developing objects that act as a mock or clone of the real object
     * 
     *     Stubbbing
     *      - allows you to define the behavior of mock objects by "stubbing" their methods
     *        where the stub object holds predefined data and provide it to answer the calls during testing
     *      - typically used duirng state verification
     * 
     *      Verifaction
     *      - provide methods to verify that certain methods were called on the mock object with 
     *        specific arguments and a certain number of times
     * 
     *      Spying
     *      - allows for partial mocking, where you can mock some methods of a real object
     *        while allowing others to execute as usual.
     */


    //creates a mock instance of the MovieService class
    @Mock
    private MovieService movieService;

    //injects the MovieService mock object into the MovieController
    @InjectMocks
    private MovieController movieController;
    private AutoCloseable closeable;

    //initializes the mock objects to ensure they are ready before tests are run
    @BeforeTest
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    //closes the closeable resource to ensure that the mock objects are cleaned up properly - prevents memory leaks
    @AfterTest
    public void teardown() throws Exception{
        closeable.close();
    }

    @Test
    public void findAllMoviesTest() {
        //Given
        List<Movie> expectedMovies = Arrays.asList(new Movie(), new Movie());

        //When (stubbing)
        when(movieService.findAllMovies())
        
        //Then
        .thenReturn(expectedMovies);

        ResponseEntity<List<Movie>> response = movieController.findAllMovies();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), expectedMovies);
        Assert.assertEquals(response.getBody().size(), 2);
    }

    @Test
    public void findMovieByIdTest() {
        int movieId = 1;
        Movie expectedMovie = new Movie();
        when(movieService.findMovieById(movieId)).thenReturn(expectedMovie);

        ResponseEntity<Movie> response = movieController.findMovieById(movieId);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void createMovieTest() {
        Movie inputMovie = new Movie();
        Movie savedMovie = new Movie();
        when(movieService.saveMovie(inputMovie)).thenReturn(savedMovie);

        ResponseEntity<Movie> response = movieController.createMovie(inputMovie);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void updateMovieTest() {
        Movie inputMovie = new Movie();
        int updatedCount = 1;
        when(movieService.updateMovie(inputMovie.getId(), inputMovie.getTitle(), inputMovie.getRating(), inputMovie.getDirector()))
        .thenReturn(updatedCount);

        ResponseEntity<Integer> response = movieController.updateMovie(inputMovie);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }


    
}
