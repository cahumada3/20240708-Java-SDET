package com.skillstorm.demo.dtos;

import com.skillstorm.demo.models.Director;

/*
    Spring Data Jpa Projections (Partial Views)
    
    1. Class-Based Projections

    - constructor parameter names must match the properties of the root entity class.
    - equals and hashCode must be implemented

    2. Interface-Based Projections

    (see tutorial for example: https://www.baeldung.com/spring-data-jpa-projections)
   
    */
public class MovieTitleDirectorDto {

    private String title;
    private String directorName;

    public MovieTitleDirectorDto(String title, Director director) {
        this.title = title;
        this.directorName = director.getFirstName() + " " + director.getLastName();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((directorName == null) ? 0 : directorName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MovieTitleDirectorDto other = (MovieTitleDirectorDto) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (directorName == null) {
            if (other.directorName != null)
                return false;
        } else if (!directorName.equals(other.directorName))
            return false;
        return true;
    }

    
}
