package com.quicksilver.moviesapp.views.appstart;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.views.movieHome.HomeActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class ApplicationStartActivity extends DaggerAppCompatActivity implements ApplicationStartContracts.Navigator {
    @Inject
    ApplicationStartContracts.Presenter mApplicationStartPresenter;

    @Inject
    ApplicationStartFragment mApplicationStartFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_start);

        mApplicationStartFragment.setNavigator(this);
        mApplicationStartFragment.setPresenter(mApplicationStartPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mApplicationStartFragment)
                .commit();
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(
                this,
                HomeActivity.class
        );

        startActivity(intent);
    }
}
