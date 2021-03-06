package com.bb.movielist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.movielist.R;
import com.bb.movielist.model.MovieListResult;
import com.bb.movielist.model.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {
    @NonNull
    @Override
    public MovieListAdapter.MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_title_list_layout, parent, false);
        return new MovieListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MovieListViewHolder holder, int position) {
        holder.movieTitleText.setText(movieListResultList.getResults().get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return movieListResultList.getResults().size();
    }

    public interface MovieListInterface{}

    private MovieListResult movieListResultList;

    public MovieListAdapter(MovieListResult movieListResultList){
        this.movieListResultList = movieListResultList;
    }

    public class MovieListViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.movie_title_list_text)
        TextView movieTitleText;

        public MovieListViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
