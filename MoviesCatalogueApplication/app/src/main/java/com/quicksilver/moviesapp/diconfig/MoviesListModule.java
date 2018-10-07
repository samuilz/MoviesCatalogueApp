package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.views.moviesList.MoviesListContracts;
import com.quicksilver.moviesapp.views.moviesList.MoviesListFragment;
import com.quicksilver.moviesapp.views.moviesList.MoviesListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
 abstract class MoviesListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MoviesListFragment moviesListFragment();

    @ActivityScoped
    @Binds
    abstract MoviesListContracts.Presenter moviesListPresenter(MoviesListPresenter presenter);
}
