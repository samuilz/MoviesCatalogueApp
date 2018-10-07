package com.quicksilver.moviesapp.views.movieDetails;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.Movie;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailsFragment extends Fragment implements MovieDetailsContracts.View, RatingBar.OnRatingBarChangeListener {
    private MovieDetailsContracts.Presenter mPresenter;

    @BindView(R.id.rating_bar)
    RatingBar mRatingBar;

    @BindView(R.id.tv_rating_votes)
    TextView mTextRatingVotes;

    @BindView(R.id.tv_title)
    TextView mTextViewTitle;

    @BindView(R.id.iv_wallpaper)
    ImageView mImageViewWallpaper;

    @BindView(R.id.tv_cast)
    TextView mTextViewCast;

    @BindView(R.id.tv_description)
    TextView mTextViewDescription;

    @BindView(R.id.tv_category)
    TextView mTextCategory;
    private Movie mMovie;

    @Inject
    public MovieDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_details, container, false);

        ButterKnife.bind(this, view);
        mRatingBar.setOnRatingBarChangeListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(MovieDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMovie(Movie movie) {
        mMovie = movie;

        mTextViewTitle.setText(movie.getTitle());

        byte[] imageBytes = movie.getImageBytes();

        Bitmap bitmapImage = mPresenter.convertByteArrayToBitmap(imageBytes);
        mImageViewWallpaper.setImageBitmap(bitmapImage);

        mTextCategory.setText(movie.getCategory());
        mTextViewCast.setText(movie.getCast());
        mTextViewDescription.setText(movie.getDescription());
        mRatingBar.setRating(movie.getMovieRating().getRating());
        String ratingVotes = getString(R.string.tv_rating_votes, movie.getMovieRating().getVotes());
        mTextRatingVotes.setText(ratingVotes);
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), "Error: " + error.getMessage(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        if (!fromUser) {
            return;
        }

        mPresenter.selectMovie(mMovie, ratingBar.getRating());
        Toast.makeText(getContext(), "Votes successful!", Toast.LENGTH_SHORT).show();
    }
}
