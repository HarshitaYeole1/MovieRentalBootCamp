package com.ee.bootcamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private String userName;
    private List<Movie> rentedMovies = new ArrayList<>();

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public List<Movie> getRentedMovies() {
        return Collections.unmodifiableList(rentedMovies);
    }

    public void addRentedMovie(Movie movie){
        rentedMovies.add(movie);
    }
}
