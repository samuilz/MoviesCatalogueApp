package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.views.about.AboutUsActivity;
import com.quicksilver.moviesapp.views.appstart.ApplicationStartActivity;
import com.quicksilver.moviesapp.views.movieCreate.MoviesCreateActivity;
import com.quicksilver.moviesapp.views.movieDetails.MovieDetailsActivity;
import com.quicksilver.moviesapp.views.movieGenres.MoviesGenresActivity;
import com.quicksilver.moviesapp.views.movieHome.HomeActivity;
import com.quicksilver.moviesapp.views.moviesList.MoviesListActivity;
import com.quicksilver.moviesapp.views.users.login.LoginActivity;
import com.quicksilver.moviesapp.views.users.register.RegisterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = MoviesListModule.class)
    abstract MoviesListActivity moviesListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = MovieDetailsModule.class)
    abstract MovieDetailsActivity movieDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = MoviesCreateModule.class)
    abstract MoviesCreateActivity moviesCreateActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = MoviesGenreModule.class)
    abstract MoviesGenresActivity moviesGenresActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = ApplicationStartModule.class)
    abstract ApplicationStartActivity applicationStartActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity homeActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = AboutModule.class)
    abstract AboutUsActivity aboutTheApp();

    @ActivityScoped
    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity userActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = RegisterModule.class)
    abstract RegisterActivity registerActivity();
}
