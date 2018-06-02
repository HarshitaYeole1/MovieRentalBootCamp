package com.ee.bootcamp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MovieRentalTest {

    @Test
    public void rentMovie_shouldRentAMovie(){
        Movie movie1 = new Movie("The Shawshank Redemption", 20f);
        User testUser = new User("TestUser");

        MovieRental movieRental = new MovieRental();

        movieRental.rent(movie1, testUser);

        List<Movie> rentedMovies = testUser.getRentedMovies();

        Assert.assertEquals(Arrays.asList(movie1), rentedMovies);
    }

    @Test
    public void getMoviesListWithStatus_whenOneMovieIsRented(){
        Movie shawshankRedemption = new Movie("The Shawshank Redemption", 20f);
        MovieVM movie1 = new MovieVM(shawshankRedemption, "rented");
        MovieVM movie2 = new MovieVM(new Movie("The Godfather", 20f), "available");
        MovieVM movie3 = new MovieVM(new Movie("The Godfather : Part II", 20f), "available");
        MovieVM movie4 = new MovieVM(new Movie("The Dark Knight", 20f), "available");
        MovieVM movie5 = new MovieVM(new Movie("12 Angry Men", 20f), "available");
        MovieVM movie6 = new MovieVM(new Movie("Schindler’s List", 20f), "available");
        MovieVM movie7 = new MovieVM(new Movie("Pulp Fiction", 20f), "available");
        User testUser = new User("TestUser");
        MovieRental movieRental = new MovieRental();

        movieRental.rent(shawshankRedemption, testUser);

        List<MovieVM> movies = movieRental.getMoviesList(testUser);

        Assert.assertEquals(Arrays.asList(movie1, movie2, movie3, movie4, movie5, movie6, movie7), movies);
    }

    @Test
    public void getMoviesListWithStatus_whenTwoMoviesAreRented(){
        Movie shawshankRedemption = new Movie("The Shawshank Redemption", 20f);
        Movie theGodFather = new Movie("The Godfather", 20f);
        MovieVM movieVM1 = new MovieVM(shawshankRedemption, "rented");
        MovieVM movieVM2 = new MovieVM(theGodFather, "rented");
        MovieVM movieVM3 = new MovieVM(new Movie("The Godfather : Part II", 20f), "available");
        MovieVM movieVM4 = new MovieVM(new Movie("The Dark Knight", 20f), "available");
        MovieVM movieVM5 = new MovieVM(new Movie("12 Angry Men", 20f), "available");
        MovieVM movieVM6 = new MovieVM(new Movie("Schindler’s List", 20f), "available");
        MovieVM movieVM7 = new MovieVM(new Movie("Pulp Fiction", 20f), "available");
        User testUser = new User("TestUser");
        MovieRental movieRental = new MovieRental();

        movieRental.rent(shawshankRedemption, testUser);
        movieRental.rent(theGodFather, testUser);

        List<MovieVM> movies = movieRental.getMoviesList(testUser);

        Assert.assertEquals(Arrays.asList(movieVM1, movieVM2, movieVM3, movieVM4, movieVM5, movieVM6, movieVM7), movies);
    }

    @Test
    public void getMoviesListWithStatus_whenOneMovieIsRentedByUser1_shouldBeAvailableForUser2(){
        Movie shawshankRedemption = new Movie("The Shawshank Redemption", 20f);
        MovieVM movie1 = new MovieVM(shawshankRedemption, "available");
        MovieVM movie2 = new MovieVM(new Movie("The Godfather", 20f), "available");
        MovieVM movie3 = new MovieVM(new Movie("The Godfather : Part II", 20f), "available");
        MovieVM movie4 = new MovieVM(new Movie("The Dark Knight", 20f), "available");
        MovieVM movie5 = new MovieVM(new Movie("12 Angry Men", 20f), "available");
        MovieVM movie6 = new MovieVM(new Movie("Schindler’s List", 20f), "available");
        MovieVM movie7 = new MovieVM(new Movie("Pulp Fiction", 20f), "available");
        User testUser1 = new User("TestUser1");
        User testUser2 = new User("TestUser2");
        MovieRental movieRental = new MovieRental();

        movieRental.rent(shawshankRedemption, testUser1);

        List<MovieVM> movies = movieRental.getMoviesList(testUser2);

        Assert.assertEquals(Arrays.asList(movie1, movie2, movie3, movie4, movie5, movie6, movie7), movies);
    }

}
