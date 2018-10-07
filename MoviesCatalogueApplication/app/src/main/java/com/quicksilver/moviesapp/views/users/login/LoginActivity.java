package com.quicksilver.moviesapp.views.users.login;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.views.BaseDrawerActivity;
import com.quicksilver.moviesapp.views.movieHome.HomeActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseDrawerActivity implements LoginContracts.Navigator {
    public static final int IDENTIFIER = 7;

    @Inject
    LoginContracts.Presenter mUserPresenter;

    @Inject
    LoginFragment mLoginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginView.setPresenter(mUserPresenter);
        mLoginView.setNavigator(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mLoginView)
                .commit();
    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigate() {
        Intent navigateToHome = new Intent(
                this,
                HomeActivity.class
        );

        startActivity(navigateToHome);
    }

    @Override
    public void setUserToDrawer(String username) {
        setUsername(username);
    }
}
