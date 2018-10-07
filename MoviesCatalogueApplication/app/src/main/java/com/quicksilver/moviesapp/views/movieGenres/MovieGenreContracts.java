package com.quicksilver.moviesapp.views.movieGenres;

import com.quicksilver.moviesapp.models.Movie;

import java.util.List;

public interface MovieGenreContracts {
    interface View {
        void setPresenter(MovieGenreContracts.Presenter presenter);

        void showMovies(List<Movie> movies);

        void setNavigator(MovieGenreContracts.Navigator navigator);

        void showMovieDetails(Movie movie);

        void showError(Throwable error);
    }

    interface Presenter {
        void subscribeAction(MovieGenreContracts.View view);

        void subscribeComedy(MovieGenreContracts.View view);

        void subscribeCrime(MovieGenreContracts.View view);

        void subscribeHorror(MovieGenreContracts.View view);

        void filterMovies(View view, String pattern);

        void selectMovie(Movie movie, View view);

        void arrangeFragment(int position);
    }

    interface Navigator {
        void navigateWith(Movie movie);
    }
}
