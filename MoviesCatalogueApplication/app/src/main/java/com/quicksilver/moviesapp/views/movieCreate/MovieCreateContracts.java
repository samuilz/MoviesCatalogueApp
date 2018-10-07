package com.quicksilver.moviesapp.views.movieCreate;

import android.net.Uri;

import com.quicksilver.moviesapp.models.Movie;

import java.io.IOException;
import java.io.InputStream;

public interface MovieCreateContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void navigateToHome();

        void showLoading();

        void hideLoading();

        void setNavigator(Navigator navigator);

        void showError(Throwable error);
    }

    interface Presenter {
        void subscribe(View view);

        void addMovie(Movie movie);

        byte[] convertUriIntoByteArray(Uri uri, InputStream inputStream) throws IOException;

//        String convertByteArrayToString(byte[] mImageBytes);
    }

    interface Navigator {
        void navigateToHome();
    }
}
