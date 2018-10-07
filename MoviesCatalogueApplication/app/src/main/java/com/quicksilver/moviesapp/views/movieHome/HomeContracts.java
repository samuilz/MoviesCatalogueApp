package com.quicksilver.moviesapp.views.movieHome;

import com.quicksilver.moviesapp.models.Movie;

import java.util.List;

public interface HomeContracts {
    interface View {

        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);

        void showLatestMovies(List<Movie> movies);

        void showError(Throwable error);

        void showMovieDetails(Movie movie);
    }

    interface Presenter {
        void subscribe(View view);

        void loadLatestMovies();

        void selectMovie(Movie movie);
    }

    interface Navigator {

        void navigateWith(Movie movie);
    }
}
