package com.quicksilver.moviesapp.views.movieGenres;

import com.quicksilver.moviesapp.async.base.SchedulerProvider;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.services.base.MoviesService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MoviesGenresPresenter implements MovieGenreContracts.Presenter {
    private final MoviesService mMoviesService;
    private final SchedulerProvider mSchedulerProvider;

    private MovieGenreContracts.View mViewAction;
    private MovieGenreContracts.View mViewComedy;
    private MovieGenreContracts.View mViewCrime;
    private MovieGenreContracts.View mViewHorror;

    @Inject
    public MoviesGenresPresenter(
            MoviesService moviesService, SchedulerProvider schedulerProvider) {

        mMoviesService = moviesService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribeAction(MovieGenreContracts.View view) {
        mViewAction = view;
    }

    @Override
    public void subscribeComedy(MovieGenreContracts.View view) {
        mViewComedy = view;
    }

    @Override
    public void subscribeCrime(MovieGenreContracts.View view) {
        mViewCrime = view;
    }

    @Override
    public void subscribeHorror(MovieGenreContracts.View view) {
        mViewHorror = view;
    }

    @Override
    public void filterMovies(MovieGenreContracts.View view, String pattern) {
        Disposable disposable = Observable.create((ObservableOnSubscribe<List<Movie>>) emitter -> {
            List<Movie> filteredMovies = mMoviesService.getFilteredMovies(pattern);
            emitter.onNext(filteredMovies);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(view::showMovies, view::showError);
    }

    @Override
    public void selectMovie(Movie movie, MovieGenreContracts.View view) {
        view.showMovieDetails(movie);
    }

    @Override
    public void arrangeFragment(int position) {
        switch (position) {
            case 0:
                filterMovies(mViewAction, ActionGenreFragment.TITLE);
            case 1:
                filterMovies(mViewComedy, ComedyGenreFragment.TITLE);
            case 2:
                filterMovies(mViewCrime, CrimeGenreFragment.TITLE);
            case 3:
                filterMovies(mViewHorror, HorrorGenreFragment.TITLE);
        }
    }
}
