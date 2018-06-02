package com.ee.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Movie {
    private String name;
    private Float price;

    public Movie(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) &&
                Objects.equals(price, movie.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

}
