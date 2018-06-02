package com.ee.bootcamp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRental {
    private static Movie shawshankRedemption = new Movie("The Shawshank Redemption", 20f);
    private static Movie godFather = new Movie("The Godfather", 20f);
    private static Movie godFather2 = new Movie("The Godfather : Part II", 20f);
    private static Movie darkKnight = new Movie("The Dark Knight", 20f);
    private static Movie angryMen = new Movie("12 Angry Men", 20f);
    private static Movie shindlersList = new Movie("Schindler’s List", 20f);
    private static Movie pulpFinction = new Movie("Pulp Fiction", 20f);

    private static List<Movie> movies = Arrays.asList(shawshankRedemption, godFather, godFather2, darkKnight, angryMen, shindlersList, pulpFinction);

    public List<MovieVM> getMoviesList(User testUser) {
        List<Movie> rentedMovies = testUser.getRentedMovies();

        List<MovieVM> movieVMS = movies.stream().map(movie ->
                new MovieVM(movie, rentedMovies.contains(movie) ? "rented" : "available")
        ).collect(Collectors.toList());

        return movieVMS;
    }

    public void rent(Movie movie1, User testUser) {
        testUser.addRentedMovie(movie1);
    }
}
