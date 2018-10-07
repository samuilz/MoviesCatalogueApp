package com.quicksilver.moviesapp.views.movieHome;

import com.quicksilver.moviesapp.async.base.SchedulerProvider;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.services.base.MoviesService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class HomePresenter implements HomeContracts.Presenter {
    private final MoviesService mMoviesService;
    private final SchedulerProvider mSchedulerProvider;
    private HomeContracts.View mView;

    @Inject
    public HomePresenter(MoviesService moviesService, SchedulerProvider schedulerProvider) {
        mMoviesService = moviesService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(HomeContracts.View view) {
        mView = view;
    }

    @Override
    public void loadLatestMovies() {
        Disposable disposable = Observable.create((ObservableOnSubscribe<List<Movie>>) emitter -> {
            List<Movie> latestMovies = mMoviesService.getLatestMovies();
            emitter.onNext(latestMovies);
            emitter.onComplete();
        })
            .subscribeOn(mSchedulerProvider.background())
            .observeOn(mSchedulerProvider.ui())
            .subscribe(m -> mView.showLatestMovies(m), error -> mView.showError(error));
    }

    @Override
    public void selectMovie(Movie movie) {
        mView.showMovieDetails(movie);
    }
}
