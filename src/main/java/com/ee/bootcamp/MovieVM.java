package com.ee.bootcamp;

import java.util.Objects;

public class MovieVM {
    private Movie movie;
    private String status;

    public MovieVM(Movie movie, String status) {
        this.movie = movie;
        this.status = status;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "MovieVM{" +
                "movie=" + movie +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieVM)) return false;
        MovieVM movieVM = (MovieVM) o;
        return Objects.equals(movie, movieVM.movie) &&
                Objects.equals(status, movieVM.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, status);
    }
}
