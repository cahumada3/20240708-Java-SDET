package com.skillstorm.demo.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.demo.models.Director;
import com.skillstorm.demo.models.Movie;
import com.skillstorm.demo.repositories.DirectorRepository;
import com.skillstorm.demo.repositories.MovieRepository;

import jakarta.transaction.Transactional;

@Service
public class MovieService {

    private MovieRepository repo;

    private DirectorRepository directorRepo;

    // use dependency injection to get an instance of the MovieRepository
    public MovieService(MovieRepository repo, DirectorRepository directorRepo) {
        this.repo = repo;
        this.directorRepo = directorRepo;
    }

    public Iterable<Movie> findAll() {
        return repo.findAll();
    }

    public Optional<Movie> findById(int id) {
        return repo.findById(id);
    }

    // TODO 1 Transaction
    @Transactional // Rollback on RuntimeExceptions
    public Movie save(Movie movie) {
        // Assume, movie != null and director != null due to @Valid
        // Check if director exists
        Director director = movie.getDirector();
        if (directorRepo.existsById(director.getId())) {
            Director existingDirector = directorRepo.findById(director.getId()).get();
            movie.setDirector(existingDirector); // THIS IS THE MAGIC CREATING THE FK ASSOCIATION
        } else {
            throw new RuntimeException("Cannot save movie because Director " + director + " does not exist"); // runtimeexception
        }
        /*
         * User user = movie.getUser();
         * if (userRepo.existsById(user.getId())) {
         *    User existingUser = userRepo.findById(user.getId()).get();
         * }
         * 
         */
        // else 
        // cascade creation (configured already by @Cascade(CasecadeType.PERSIST))
        return repo.save(movie); // TODO add more logic
    }

    // HTTP PUT should be indempotent so don't create new here
    public void update(int id, Movie movie) {
        /*
        Do you want to create a new record in the db if the update an entity with an id that doesn't exist?
         */
        if (!repo.existsById(id)) 
            throw new NoSuchElementException("Movie with id " + id + " does not exist");
        movie.setId(id);
        repo.save(movie);
    }

    public void deleteById(int id) {
        /*
        Do you want to warn them they are trying to delete a record with id that doesn't exist?
        - no because HTTP DELETE requests should be indempotent (making the same request twice has the same result)
         */
        repo.deleteById(id);
    }


}
