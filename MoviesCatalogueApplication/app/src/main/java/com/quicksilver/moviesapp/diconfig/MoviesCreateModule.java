package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.views.movieCreate.MovieCreateContracts;
import com.quicksilver.moviesapp.views.movieCreate.MoviesCreateFragment;
import com.quicksilver.moviesapp.views.movieCreate.MoviesCreatePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MoviesCreateModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MoviesCreateFragment moviesCreateFragment();

    @ActivityScoped
    @Binds
    abstract MovieCreateContracts.Presenter moviesCreatePresenter(MoviesCreatePresenter presenter);
}
