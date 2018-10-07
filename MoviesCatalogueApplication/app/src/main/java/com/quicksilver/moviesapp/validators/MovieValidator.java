package com.quicksilver.moviesapp.validators;

import com.quicksilver.moviesapp.Constants;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.validators.base.Validator;

public class MovieValidator implements Validator<Movie> {

    public MovieValidator() {

    }

    @Override
    public boolean isValid(Movie object) throws IllegalArgumentException {
        return object != null &&
                isTitleValid(object) && isCastValid(object) &&
                isDescriptionValid(object) && isImageValid(object);
    }
    private boolean isDescriptionValid(Movie object) {
        boolean isMinLengthValid = object.getDescription().length() >= Constants.MOVIE_DESCRIPTION_MIN_LENGTH;
        boolean isMaxLengthValid = object.getDescription().length() <= Constants.MOVIE_DESCRIPTION_MAX_LENGTH;

        if (!isMinLengthValid || !isMaxLengthValid) {
            throw new IllegalArgumentException("Invalid description");
        }

        return true;
    }

    private boolean isTitleValid(Movie object) {
        boolean isMinLengthValid = object.getTitle().length() >= Constants.MOVIE_TITLE_MIN_LENGTH;
        boolean isMaxLengthValid = object.getTitle().length() <= Constants.MOVIE_TITLE_MAX_LENGTH;

        if (!isMinLengthValid || !isMaxLengthValid) {
            throw new IllegalArgumentException("Invalid title");
        }

        return true;
    }

    private boolean isCastValid(Movie object) {
        boolean isMinLengthValid = object.getCast().length() >= Constants.MOVIE_CAST_MIN_LENGTH;
        boolean isMaxLengthValid = object.getCast().length() <= Constants.MOVIE_CAST_MAX_LENGTH;

        if (!isMinLengthValid || !isMaxLengthValid) {
            throw new IllegalArgumentException("Invalid cast");
        }

        return true;
    }

    private boolean isImageValid(Movie object) {
        byte[] imageBytes = object.getImageBytes();

        if (imageBytes == null) {
            throw new IllegalArgumentException("Image missed");
        }

        return true;
    }
}
