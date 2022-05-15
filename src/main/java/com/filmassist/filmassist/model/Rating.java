package com.filmassist.filmassist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userClassId;

    private long filmId;

    private long numberOfRatings;

    private double rating;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserClassId() {
        return userClassId;
    }

    public void setUserClassId(long userClassId) {
        this.userClassId = userClassId;
    }

    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    public long getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(long numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Rating(long userClassId, long filmId, long numberOfRatings, double rating) {
        this.userClassId = userClassId;
        this.filmId = filmId;
        this.numberOfRatings = numberOfRatings;
        this.rating = rating;
    }

    public Rating() {
    }
}
