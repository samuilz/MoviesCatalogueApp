package com.quicksilver.moviesapp.views.movieCreate;

import android.net.Uri;
import android.util.Base64;

import com.quicksilver.moviesapp.async.base.SchedulerProvider;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.services.base.MoviesService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MoviesCreatePresenter implements MovieCreateContracts.Presenter {
    private static final int BUFFER_SIZE = 1024;
    private final MoviesService mMoviesService;
    private final SchedulerProvider mSchedulerProvider;
    private MovieCreateContracts.View mView;

    @Inject
    public MoviesCreatePresenter(MoviesService moviesService, SchedulerProvider schedulerProvider) {
        this.mMoviesService = moviesService;
        this.mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(MovieCreateContracts.View view) {
        this.mView = view;
    }

    @Override
    public void addMovie(Movie movie) {
        Disposable disposable = Observable.create((ObservableOnSubscribe<Movie>) emitter -> {
            mMoviesService.createMovie(movie);
            emitter.onNext(movie);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(m -> mView.navigateToHome(), error -> mView.showError(error));
    }

    @Override
    public byte[] convertUriIntoByteArray(Uri uri, InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];

        int len = 0;
        while((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }

        return byteBuffer.toByteArray();
    }

//    @Override
//    public String convertByteArrayToString(byte[] imageBytes) {
//        String string = Base64.encodeToString(imageBytes, 2);
//        return Base64.encodeToString(imageBytes, Base64.NO_WRAP);
//    }
}
