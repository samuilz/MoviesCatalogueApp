package com.movies.restapi.entities;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageBytes;
    private String cast;
    @Column(columnDefinition = "VARCHAR(1000)")
    private String description;
    private String category;
//        @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id")
    private MovieRating movieRating;

    public Movie() {

    }

    public Movie(int id, String title, String cast, String description, String category, byte[] imageBytes, MovieRating movieRating) {
        this.id = id;
        this.title = title;
        this.imageBytes = imageBytes;
        this.cast = cast;
        this.description = description;
        this.category = category;
        this.movieRating = movieRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MovieRating getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(MovieRating movieRating) {
        this.movieRating = movieRating;
    }
}
