package com.quicksilver.moviesapp.models;

import java.io.Serializable;

public class MovieRating implements Serializable {
    private float rating;

    private int votes;

    public MovieRating() {

    }

    public MovieRating(float rating, int votes) {
        this.rating = rating;
        this.votes = votes;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
