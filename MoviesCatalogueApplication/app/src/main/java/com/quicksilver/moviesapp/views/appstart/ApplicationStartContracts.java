package com.quicksilver.moviesapp.views.appstart;

public interface ApplicationStartContracts {
    interface View {
        void showLoading();

        void hideLoading();

        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);

        void showError(Throwable error);

        void navigateToHome();
    }

    interface Presenter {
        void subscribe(View view);

        void load();
    }

    interface Navigator {
        void navigateToHome();
    }
}
