package com.quicksilver.moviesapp.views.movieDetails;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.quicksilver.moviesapp.async.base.SchedulerProvider;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.services.base.MoviesService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MovieDetailsPresenter implements MovieDetailsContracts.Presenter {
    private MovieDetailsContracts.View mView;
    private MoviesService mMovieService;
    private SchedulerProvider mSchedulerProvider;

    @Inject
    public MovieDetailsPresenter(MoviesService mMovieService, SchedulerProvider mSchedulerProvider) {
        this.mMovieService = mMovieService;
        this.mSchedulerProvider = mSchedulerProvider;
    }

    @Override
    public void subscribe(MovieDetailsContracts.View view) {
        this.mView = view;
    }

    @Override
    public void loadMovieId(int id) {
        Disposable disposable = Observable.create((ObservableOnSubscribe<Movie>) emitter -> {
            Movie movie = mMovieService.getDetailById(id + 1);
            emitter.onNext(movie);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(m -> mView.showMovie(m), error -> mView.showError(error));
    }

    @Override
    public void selectMovie(Movie movie, float rating) {
        Disposable disposable = Observable.create((ObservableOnSubscribe<Movie>) emitter -> {
            float nextRating = calculateRating
                    (movie.getMovieRating().getRating(), movie.getMovieRating().getVotes(), rating);

            movie.getMovieRating().setRating(nextRating);
            movie.getMovieRating().setVotes(movie.getMovieRating().getVotes() + 1);

            int id = movie.getId();
            mMovieService.updateMovie(id, movie);

            emitter.onNext(movie);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(m -> mView.showMovie(m), error -> mView.showError(error));
    }

    @Override
    public Bitmap convertByteArrayToBitmap(byte[] imageBytes) {
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
    }

    @Override
    public float calculateRating(float rating, int votes, float currentVoteRating) {
        float totalPreviousRate = rating * votes;

        float nextRating = (totalPreviousRate + currentVoteRating) / (votes + 1);
        return nextRating;
    }
}

