package com.movies.restapi.entities;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class MovieRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float rating;

    private int votes;

//    @OneToOne(mappedBy = "movieRating")
////    @JoinColumn(name = "movie_id")
//    private Movie movie;

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
