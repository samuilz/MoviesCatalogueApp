package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.views.movieDetails.MovieDetailsContracts;
import com.quicksilver.moviesapp.views.movieDetails.MovieDetailsFragment;
import com.quicksilver.moviesapp.views.movieDetails.MovieDetailsPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class MovieDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MovieDetailsFragment movieDetailsFragment();

    @ActivityScoped
    @Binds
    abstract MovieDetailsContracts.Presenter movieDetailsPresenter(MovieDetailsPresenter presenter);
}
