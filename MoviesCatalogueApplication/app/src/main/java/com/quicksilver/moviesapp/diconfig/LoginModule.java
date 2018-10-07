package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.views.users.login.LoginContracts;
import com.quicksilver.moviesapp.views.users.login.LoginFragment;
import com.quicksilver.moviesapp.views.users.login.LoginPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract LoginFragment userFragment();

    @ActivityScoped
    @Binds
    abstract LoginContracts.Presenter presenter(LoginPresenter loginPresenter);
}
