package com.moviecatalogue.server.models;

public class Movie {
    private int id;
    private String title;
    private String imageUrl;
    private String cast;
    private String description;
    public String category;
    public float rating;

    public Movie() {

    }

    public Movie(int id, String title, String imageUrl, String cast, String description, String category) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.cast = cast;
        this.description = description;
        this.category = category;
        this.rating = 0;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCast() {
        return this.cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
