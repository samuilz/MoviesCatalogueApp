package com.quicksilver.moviesapp.views.users.register;

import com.quicksilver.moviesapp.models.User;

public interface RegisterContracts {
    interface View {

        void showUserProfile();

        void setPresenter(Presenter presenter);

        void navigateToHome();

        void showError(Throwable error);

        void setNavigator(Navigator navigator);
    }

    interface Presenter {
        void subscribe(View view);

        void register(User user);
    }

    interface Navigator {
        void navigate();
    }
}
