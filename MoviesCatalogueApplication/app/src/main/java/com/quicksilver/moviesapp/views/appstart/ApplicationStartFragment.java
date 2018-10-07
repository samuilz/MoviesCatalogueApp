package com.quicksilver.moviesapp.views.appstart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.quicksilver.moviesapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApplicationStartFragment extends Fragment implements ApplicationStartContracts.View {
    private ApplicationStartContracts.Presenter mPresenter;
    private ApplicationStartContracts.Navigator mNavigator;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @Inject
    public ApplicationStartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_application_start, container, false);

        ButterKnife.bind(this, view);

        mProgressBar.getIndeterminateDrawable().setColorFilter(0xFF3568A3, android.graphics.PorterDuff.Mode.MULTIPLY);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.load();
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(ApplicationStartContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setNavigator(ApplicationStartContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToHome() {
        mNavigator.navigateToHome();
    }
}
