package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.Constants;
import com.quicksilver.moviesapp.http.HttpRequester;
import com.quicksilver.moviesapp.http.OkHttpHttpRequester;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {
    @Provides
    public HttpRequester httpRequester() {
        return new OkHttpHttpRequester();
    }

    @Provides
    @Named("serverUrl")
    public String baseServerUrl() {
        return Constants.BASE_SERVER_URL;
    }
}
