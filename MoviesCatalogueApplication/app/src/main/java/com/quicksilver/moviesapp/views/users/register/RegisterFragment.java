package com.quicksilver.moviesapp.views.users.register;


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
import com.quicksilver.moviesapp.views.users.login.LoginActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements RegisterContracts.View {

    private RegisterContracts.Presenter mPresenter;

    @BindView(R.id.tv_go_to_login_form)
    TextView mGoToLoginForm;

    @BindView(R.id.btn_register)
    Button mRegisterButton;

    @BindView(R.id.et_username)
    EditText mEditTextUsername;

    @BindView(R.id.et_password)
    EditText mEditTextPassword;
    private RegisterContracts.Navigator mNavigator;

    @Inject
    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_register, container, false);

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
    public void setPresenter(RegisterContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void navigateToHome() {
        mNavigator.navigate();
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setNavigator(RegisterContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @OnClick({R.id.tv_go_to_login_form, R.id.btn_register})
    public void onClick(View view) {
        if (view.getId() == R.id.tv_go_to_login_form) {
            Intent intent = new Intent(
                    getContext(),
                    LoginActivity.class
            );

            startActivity(intent);
        } else if(view.getId() == R.id.btn_register) {
            String username = mEditTextUsername.getText().toString();
            String password = mEditTextPassword.getText().toString();

            User user = new User(username, password);
            mPresenter.register(user);
        }
    }
}
