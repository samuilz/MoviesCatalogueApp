package com.quicksilver.moviesapp.diconfig;

import android.app.Application;

import com.quicksilver.moviesapp.AndroidApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        AppModule.class,
        HttpModule.class,
        AsyncModule.class,
        ParsersModule.class,
        ServicesModule.class,
        RepositoriesModule.class,
        ValidatorsModule.class,
        ViewModule.class
})
public interface AppComponent extends AndroidInjector<AndroidApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
