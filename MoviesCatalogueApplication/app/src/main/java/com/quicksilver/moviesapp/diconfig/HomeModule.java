package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.views.movieHome.HomeContracts;
import com.quicksilver.moviesapp.views.movieHome.HomeFragment;
import com.quicksilver.moviesapp.views.movieHome.HomePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract HomeFragment homeFragment();

    @ActivityScoped
    @Binds
    abstract HomeContracts.Presenter homePresenter(HomePresenter presenter);
}
