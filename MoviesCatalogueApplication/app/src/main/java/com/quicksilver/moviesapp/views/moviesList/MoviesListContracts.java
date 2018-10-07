package com.quicksilver.moviesapp.views.moviesList;

import com.quicksilver.moviesapp.models.Movie;

import java.util.List;

public interface MoviesListContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showMovies(List<Movie> movies);

        void setNavigator(Navigator navigator);

        void showLoading();

        void showMovieDetails(Movie movie);

        void showError(Throwable error);
    }

    interface Presenter {
        void subscribe(View view);

        void loadMovies();

        void filterMovies(String pattern);

        void selectMovie(Movie movie);
    }

    interface Navigator {
        void navigateWith(Movie movie);
    }
}
