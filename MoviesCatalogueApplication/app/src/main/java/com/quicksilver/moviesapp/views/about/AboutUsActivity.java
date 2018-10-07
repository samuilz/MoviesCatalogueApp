package com.quicksilver.moviesapp.views.about;

import android.os.Bundle;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class AboutUsActivity extends BaseDrawerActivity {

    public static final int IDENTIFIER = 6;

    @Inject
    AboutUsFragment mFragment;

    @Inject
    AboutUsContracts.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        ButterKnife.bind(this);

        setSupportActionBar(getDrawerToolbar());

        mFragment.setPresenter(mPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mFragment)
                .commit();
    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }
}
