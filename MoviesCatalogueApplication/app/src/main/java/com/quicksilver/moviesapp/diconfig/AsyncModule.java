package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.async.AsyncSchedulerProvider;
import com.quicksilver.moviesapp.async.base.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AsyncModule {
    @Provides
    @Singleton
    public SchedulerProvider schedulerProvider() {
        return AsyncSchedulerProvider.getInstance();
    }
}
