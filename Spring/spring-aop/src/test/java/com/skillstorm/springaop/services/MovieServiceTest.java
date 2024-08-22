package com.skillstorm.springaop.services;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.skillstorm.springaop.models.Movie;
import com.skillstorm.springaop.repositories.MovieRepository;

public class MovieServiceTest {
    
    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;
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
        List<Movie> expectedMovies = Arrays.asList(new Movie(), new Movie());
        when(movieRepository.findAll()).thenReturn(expectedMovies);

        List<Movie> response = movieService.findAllMovies();

        Assert.assertEquals(response.size(), 2);
    }
}
