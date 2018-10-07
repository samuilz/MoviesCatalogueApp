package com.quicksilver.moviesapp.views.movieHome;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.views.BaseDrawerActivity;
import com.quicksilver.moviesapp.views.movieDetails.MovieDetailsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class HomeActivity extends BaseDrawerActivity implements HomeContracts.Navigator {
    public static final int IDENTIFIER = 1;

    @Inject
    HomeFragment mHomeView;

    @Inject
    HomeContracts.Presenter mHomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        setSupportActionBar(getDrawerToolbar());

        mHomeView.setNavigator(this);
        mHomeView.setPresenter(mHomePresenter);

        getIntent();

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mHomeView)
                .commit();
    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateWith(Movie movie) {
        Intent intent = new Intent(
                this,
                MovieDetailsActivity.class
        );

        intent.putExtra("MOVIE", movie);
        startActivity(intent);
    }
}
