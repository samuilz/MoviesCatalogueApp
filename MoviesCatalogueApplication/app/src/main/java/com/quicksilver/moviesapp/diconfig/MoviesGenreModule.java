package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.views.movieGenres.ActionGenreFragment;
import com.quicksilver.moviesapp.views.movieGenres.ComedyGenreFragment;
import com.quicksilver.moviesapp.views.movieGenres.CrimeGenreFragment;
import com.quicksilver.moviesapp.views.movieGenres.HorrorGenreFragment;
import com.quicksilver.moviesapp.views.movieGenres.MovieGenreContracts;
import com.quicksilver.moviesapp.views.movieGenres.MoviesGenresPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MoviesGenreModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract ComedyGenreFragment comedyGenreFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ActionGenreFragment actionGenreFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract HorrorGenreFragment horrorGenreFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract CrimeGenreFragment crimeGenreFragment();

    @ActivityScoped
    @Binds
    abstract MovieGenreContracts.Presenter movieGenrePresenter(MoviesGenresPresenter presenter);
}
