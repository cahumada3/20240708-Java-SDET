package com.skillstorm.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.demo.models.Director;
import com.skillstorm.demo.repositories.DirectorRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/directors")
public class DirectorController {

    private DirectorRepository repo;

    public DirectorController(DirectorRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{id}")
    public Director getMethodName(@PathVariable int id) {
        return repo.findById(id).get();
    }
    

    @GetMapping()
    public List<Director> findAll() {
        return repo.findAll();
    }
    


}
