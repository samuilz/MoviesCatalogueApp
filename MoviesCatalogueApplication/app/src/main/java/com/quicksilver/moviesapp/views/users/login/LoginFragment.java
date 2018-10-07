package com.quicksilver.moviesapp.views.users.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.User;
import com.quicksilver.moviesapp.views.users.register.RegisterActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContracts.View {

    private LoginContracts.Presenter mPresenter;

    @BindView(R.id.tv_go_to_register_form)
    TextView mGoToRegisterForm;

    @BindView(R.id.btn_login)
    Button mLoginButton;

    @BindView(R.id.et_username)
    EditText mEditTextUsername;

    @BindView(R.id.et_password)
    EditText mEditTextPassword;
    private LoginContracts.Navigator mNavigator;

    @Inject
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void showUserProfile() {

    }

    @Override
    public void setPresenter(LoginContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setNavigator(LoginContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void navigateToHome() {
        mNavigator.navigate();
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.tv_go_to_register_form, R.id.btn_login})
    public void onClick(View view) {
        if (view.getId() == R.id.tv_go_to_register_form) {
            Intent intent = new Intent(
                    getContext(),
                    RegisterActivity.class
            );

            startActivity(intent);
        } else if (view.getId() == R.id.btn_login) {
            String username = mEditTextUsername.getText().toString();
            String password = mEditTextPassword.getText().toString();

            User user = new User(username, password);
            mPresenter.login(user);

            mNavigator.setUserToDrawer(username);
        }
    }
}
