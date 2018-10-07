package com.quicksilver.moviesapp.views.about;

public interface AboutUsContracts {

    interface View{

        void setView();

        void setPresenter(Presenter presenter);
    }

    interface Presenter{

        void subscribe(View view);

        void setView();
    }
}
