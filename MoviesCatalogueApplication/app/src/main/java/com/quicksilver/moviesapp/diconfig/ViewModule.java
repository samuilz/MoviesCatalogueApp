package com.quicksilver.moviesapp.diconfig;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.quicksilver.moviesapp.views.moviesList.MoviesAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {
    @Provides
    public RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> movieArrayAdapter(Context context) {
        return new MoviesAdapter();
    }
}
