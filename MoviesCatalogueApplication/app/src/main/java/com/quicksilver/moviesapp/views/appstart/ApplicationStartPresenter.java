package com.quicksilver.moviesapp.views.appstart;

import com.quicksilver.moviesapp.async.base.SchedulerProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class ApplicationStartPresenter implements ApplicationStartContracts.Presenter {
    private static final int DELAY_TIME = 3000;
    private ApplicationStartContracts.View mView;

    private SchedulerProvider mSchedulerProvider;

    @Inject
    public ApplicationStartPresenter(SchedulerProvider schedulerProvider) {
        this.mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(ApplicationStartContracts.View view) {
        mView = view;
    }

    @Override
    public void load() {
        Disposable disposable = Observable.create((ObservableOnSubscribe<ApplicationStartContracts.View>) emitter -> {
            emitter.onNext(mView);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnNext(ApplicationStartContracts.View::showLoading)
                .delay(DELAY_TIME, TimeUnit.MILLISECONDS)
                .doOnSubscribe(v -> mView.hideLoading())
                .subscribe(v -> mView.navigateToHome(), error -> mView.showError(error));
    }
}
