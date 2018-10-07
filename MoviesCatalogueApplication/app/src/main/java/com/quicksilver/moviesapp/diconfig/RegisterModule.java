package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.views.users.login.LoginFragment;
import com.quicksilver.moviesapp.views.users.register.RegisterContracts;
import com.quicksilver.moviesapp.views.users.register.RegisterPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RegisterModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract LoginFragment userFragment();

    @ActivityScoped
    @Binds
    abstract RegisterContracts.Presenter presenter(RegisterPresenter registerPresenter);
}
