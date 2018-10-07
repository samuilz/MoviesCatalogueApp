package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.views.appstart.ApplicationStartContracts;
import com.quicksilver.moviesapp.views.appstart.ApplicationStartFragment;
import com.quicksilver.moviesapp.views.appstart.ApplicationStartPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ApplicationStartModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract ApplicationStartFragment applicationStartFragment();

    @ActivityScoped
    @Binds
    abstract ApplicationStartContracts.Presenter applicationStartPresenter(ApplicationStartPresenter presenter);
}
