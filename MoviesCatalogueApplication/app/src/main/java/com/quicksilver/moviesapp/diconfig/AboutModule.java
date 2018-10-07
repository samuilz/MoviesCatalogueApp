package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.views.about.AboutUsContracts;
import com.quicksilver.moviesapp.views.about.AboutUsFragment;
import com.quicksilver.moviesapp.views.about.AboutUsPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AboutModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract AboutUsFragment aboutTheAppFragment();

    @ActivityScoped
    @Binds
    abstract AboutUsContracts.Presenter createPresenter(AboutUsPresenter presenter);
}
