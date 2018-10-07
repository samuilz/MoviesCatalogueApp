package com.quicksilver.moviesapp.views.about;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.quicksilver.moviesapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment implements AboutUsContracts.View{

    @BindView(R.id.tv_about)
    TextView mTextViewAbout;

    @BindView(R.id.iv_image)
    ImageView mImageViewWarner;

    private AboutUsContracts.Presenter mPresenter;

    @Inject
    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.setView();
    }

    @Override
    public void setView() {
        mTextViewAbout.setText(R.string.about_us_info);
    }

    @Override
    public void setPresenter(AboutUsContracts.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
