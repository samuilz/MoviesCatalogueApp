package com.quicksilver.moviesapp.views.movieCreate;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.models.MovieRating;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesCreateFragment extends Fragment implements MovieCreateContracts.View {
    private static final int PICK_IMAGE = 100;
    private static final int RESULT_OK = -1;
    private MovieCreateContracts.Navigator mNavigator;
    private MovieCreateContracts.Presenter mPresenter;
    private ArrayAdapter<String> mSpinnerAdapter;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.relative_layout)
    RelativeLayout mRelativeLayout;

    @BindView(R.id.et_title)
    TextView mTextViewTitle;

    @BindView(R.id.et_cast)
    TextView mTextViewCast;

    @BindView(R.id.et_description)
    TextView mTextViewDescription;

    @BindView(R.id.spinner_categories)
    Spinner mSpinnerCategories;

    @BindView(R.id.btn_create)
    Button mButtonCreate;

    private byte[] mImageBytes;

    @Inject
    public MoviesCreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies_create, container, false);

        ButterKnife.bind(this, view);

        String[] categories = {"Comedy", "Crime", "Action", "Horror"};
        mSpinnerAdapter = new ArrayAdapter<>(
                getContext(),
//                R.layout.spinner_item,
                android.R.layout.simple_spinner_dropdown_item,
                categories);

        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinnerCategories.setAdapter(mSpinnerAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(MovieCreateContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void navigateToHome() {
        mNavigator.navigateToHome();
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
        mRelativeLayout.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
        mRelativeLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void setNavigator(MovieCreateContracts.Navigator navigator) {
        this.mNavigator = navigator;
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btn_upload_image)
    public void OnClick(View view) {
        Intent intentToGallery = new Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI
        );

        startActivityForResult(intentToGallery, PICK_IMAGE);
    }

    @OnClick(R.id.btn_create)
    public void onClick(View view) {
        String title = mTextViewTitle.getText().toString();
        String cast = mTextViewCast.getText().toString();
        String description = mTextViewDescription.getText().toString();
        String category = mSpinnerCategories.getSelectedItem().toString();

        Movie movie = new Movie(title, cast, description, category, mImageBytes, new MovieRating(0.0f, 0));
        mPresenter.addMovie(movie);
    }

    @OnItemSelected(R.id.spinner_categories)
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#E8f3FC"));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();

            try {
                InputStream inputStream = getActivity().getContentResolver().openInputStream(uri);

                mImageBytes = mPresenter.convertUriIntoByteArray(uri, inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
