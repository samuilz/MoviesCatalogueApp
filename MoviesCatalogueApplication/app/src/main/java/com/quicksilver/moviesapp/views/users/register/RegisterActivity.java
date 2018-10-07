package com.quicksilver.moviesapp.views.users.register;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.views.BaseDrawerActivity;
import com.quicksilver.moviesapp.views.movieHome.HomeActivity;

import javax.inject.Inject;

public class RegisterActivity extends BaseDrawerActivity implements RegisterContracts.Navigator{
    private static final int IDENTIFIER = 8;

    @Inject
    RegisterContracts.Presenter mRegisterPresenter;

    @Inject
    RegisterFragment mRegisterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mRegisterView.setPresenter(mRegisterPresenter);
        mRegisterView.setNavigator(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mRegisterView)
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
}
