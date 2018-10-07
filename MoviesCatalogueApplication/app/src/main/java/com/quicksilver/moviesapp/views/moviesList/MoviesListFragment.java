package com.quicksilver.moviesapp.views.moviesList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.Movie;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesListFragment extends Fragment implements MoviesListContracts.View, MoviesAdapter.onMovieClickListener {

    @BindView(R.id.rv_movies)
    RecyclerView mRecyclerViewMovies;

    private MoviesListContracts.Navigator mNavigator;

    @Inject
    MoviesAdapter mMoviesAdapter;

    private GridLayoutManager mMoviesViewLayoutManager;
    private MoviesListContracts.Presenter mPresenter;

    @Inject
    public MoviesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_movies_list, container, false);

        ButterKnife.bind(this, view);

        mMoviesAdapter.setOnMovieClickListener(this);
        mRecyclerViewMovies.setAdapter(mMoviesAdapter);

        mMoviesViewLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerViewMovies.setLayoutManager(mMoviesViewLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadMovies();
    }

    @Override
    public void setPresenter(MoviesListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMovies(List<Movie> movies) {
        mMoviesAdapter.clear();
        mMoviesAdapter.addAll(movies);

        // refresh changes
        mMoviesAdapter.notifyDataSetChanged();
    }

    @Override
    public void setNavigator(MoviesListContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void showLoading() {
        mRecyclerViewMovies.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMovieDetails(Movie movie) {
        mNavigator.navigateWith(movie);
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(Movie movie) {
        mPresenter.selectMovie(movie);
    }
}
