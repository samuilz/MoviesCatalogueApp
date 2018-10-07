package com.quicksilver.moviesapp.views.users.login;

import com.quicksilver.moviesapp.models.User;

public interface LoginContracts {
    interface View {

        void showUserProfile();

        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);

        void navigateToHome();

        void showError(Throwable error);
    }

    interface Presenter {
        void subscribe(View view);

        void login(User user);
    }

    interface Navigator {
        void navigate();

        void setUserToDrawer(String username);
    }
}
