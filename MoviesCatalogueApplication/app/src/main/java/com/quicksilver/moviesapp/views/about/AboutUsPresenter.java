package com.quicksilver.moviesapp.views.about;

import javax.inject.Inject;

public class AboutUsPresenter implements AboutUsContracts.Presenter{

    private AboutUsContracts.View mView;

    @Inject
    public AboutUsPresenter(){

    }

    @Override
    public void subscribe(AboutUsContracts.View view) {
        this.mView = view;
    }

    @Override
    public void setView() {
        mView.setView();
    }
}
