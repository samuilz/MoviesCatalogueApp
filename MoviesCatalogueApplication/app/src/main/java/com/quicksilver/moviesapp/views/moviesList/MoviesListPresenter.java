package com.quicksilver.moviesapp.views.moviesList;

import com.quicksilver.moviesapp.async.base.SchedulerProvider;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.services.base.MoviesService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;


public class MoviesListPresenter implements MoviesListContracts.Presenter {
    private MoviesListContracts.View mView;
    private final MoviesService mMoviesService;
    private final SchedulerProvider mSchedulerProvider;

    @Inject
    public MoviesListPresenter(MoviesService moviesService, SchedulerProvider schedulerProvider) {
        mMoviesService = moviesService;
        mSchedulerProvider = schedulerProvider;
    }


    @Override
    public void subscribe(MoviesListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadMovies() {
        mView.showLoading();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<List<Movie>>) emitter -> {
                    List<Movie> movies = mMoviesService.getAllMovies();
                    emitter.onNext(movies);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::showLoading)
                .subscribe(this::presentMoviesTOView, error -> mView.showError(error));
    }

    private void presentMoviesTOView(List<Movie> movies) {
        mView.showMovies(movies);
    }

    @Override
    public void filterMovies(String pattern) {
        mView.showLoading();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<List<Movie>>) emitter -> {
                    List<Movie> movies = mMoviesService.getFilteredMovies(pattern);
                    emitter.onNext(movies);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::showLoading)
                .subscribe(this::presentMoviesTOView, error -> mView.showError(error));
    }

    @Override
    public void selectMovie(Movie movie) {
        mView.showMovieDetails(movie);
    }
}
