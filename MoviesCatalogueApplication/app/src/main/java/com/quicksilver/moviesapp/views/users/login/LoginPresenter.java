package com.quicksilver.moviesapp.views.users.login;

import com.quicksilver.moviesapp.async.base.SchedulerProvider;
import com.quicksilver.moviesapp.models.User;
import com.quicksilver.moviesapp.services.base.UsersService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class LoginPresenter implements LoginContracts.Presenter {
    private final UsersService mUsersService;
    private final SchedulerProvider mSchedulerProvider;
    private LoginContracts.View mView;

    @Inject
    public LoginPresenter(UsersService usersService, SchedulerProvider schedulerProvider) {
        this.mUsersService = usersService;
        this.mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(LoginContracts.View view) {
        mView = view;
    }

    @Override
    public void login(User user) {
        Disposable disposable = Observable.create((ObservableOnSubscribe<User>) emitter -> {
            mUsersService.login(user);
            emitter.onNext(user);
            emitter.onComplete();
        })
            .subscribeOn(mSchedulerProvider.background())
            .observeOn(mSchedulerProvider.ui())
            .subscribe(v -> mView.navigateToHome(), error -> mView.showError(error));
    }
}
