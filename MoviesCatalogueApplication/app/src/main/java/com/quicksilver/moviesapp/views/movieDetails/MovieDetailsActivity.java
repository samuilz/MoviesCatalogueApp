package com.quicksilver.moviesapp.views.movieDetails;

import android.os.Bundle;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MovieDetailsActivity extends BaseDrawerActivity {
    public static final int IDENTIFIER = 3;

    @Inject
    MovieDetailsFragment mMovieDetailsFragment;

    @Inject
    MovieDetailsContracts.Presenter mMovieDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        ButterKnife.bind(this);

        setSupportActionBar(getDrawerToolbar());

        Movie movie = (Movie) getIntent().getSerializableExtra("MOVIE");
        mMovieDetailsPresenter.loadMovieId(movie.getId() - 1);
        mMovieDetailsFragment.setPresenter(mMovieDetailsPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mMovieDetailsFragment)
                .commit();
    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }
}
