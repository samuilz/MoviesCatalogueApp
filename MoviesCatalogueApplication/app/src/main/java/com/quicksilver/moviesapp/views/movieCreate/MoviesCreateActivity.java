package com.quicksilver.moviesapp.views.movieCreate;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.views.BaseDrawerActivity;
import com.quicksilver.moviesapp.views.moviesList.MoviesListActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MoviesCreateActivity extends BaseDrawerActivity implements MovieCreateContracts.Navigator{
    public static final int IDENTIFIER = 5;

    @Inject
    MoviesCreateFragment mMoviesCreateFragment;

    @Inject
    MovieCreateContracts.Presenter mMoviesCreatePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_create);

        ButterKnife.bind(this);

        setSupportActionBar(getDrawerToolbar());

        mMoviesCreateFragment.setNavigator(this);
        mMoviesCreateFragment.setPresenter(mMoviesCreatePresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mMoviesCreateFragment)
                .commit();
    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(
                this,
                MoviesListActivity.class
        );

        startActivity(intent);
    }
}
