package com.quicksilver.moviesapp.views.moviesList;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.views.BaseDrawerActivity;
import com.quicksilver.moviesapp.views.movieDetails.MovieDetailsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MoviesListActivity extends BaseDrawerActivity implements MoviesListContracts.Navigator {

    public static final int IDENTIFIER = 2;

    @Inject
    MoviesListFragment mMoviesListFragment;

    @Inject
    MoviesListContracts.Presenter mMoviesListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        ButterKnife.bind(this);

        setSupportActionBar(getDrawerToolbar());

        mMoviesListFragment.setNavigator(this);
        mMoviesListFragment.setPresenter(mMoviesListPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mMoviesListFragment)
                .commit();
    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateWith(Movie movie) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);

        intent.putExtra("MOVIE", movie);
        startActivity(intent);
    }
}
