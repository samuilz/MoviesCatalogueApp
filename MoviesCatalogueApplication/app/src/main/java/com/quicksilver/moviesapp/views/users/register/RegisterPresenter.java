package com.quicksilver.moviesapp.views.users.register;

import com.quicksilver.moviesapp.async.base.SchedulerProvider;
import com.quicksilver.moviesapp.models.User;
import com.quicksilver.moviesapp.services.base.UsersService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class RegisterPresenter implements RegisterContracts.Presenter{

    private final UsersService mUsersService;
    private final SchedulerProvider mSchedulerProvider;
    private RegisterContracts.View mView;

    @Inject
    public RegisterPresenter(UsersService usersService, SchedulerProvider schedulerProvider) {
        this.mUsersService = usersService;
        this.mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(RegisterContracts.View view) {
        mView = view;
    }

    @Override
    public void register(User user) {
        Disposable disposable = Observable.create((ObservableOnSubscribe<User>) emitter -> {
            mUsersService.register(user);
            emitter.onNext(user);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(v -> mView.navigateToHome(), error -> mView.showError(error));
    }
}
