package com.bb.movielist.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.bb.movielist.R;
import com.bb.movielist.adapter.MovieListAdapter;
import com.bb.movielist.model.MovieListResult;
import com.bb.movielist.model.TransportObj;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListFragment extends Fragment {

    PassMovieData movieDataPasser;

    @BindView(R.id.movie_title)
    EditText movieTitleText;

    @BindView(R.id.search_movie)
    Button searchMovieButton;

    @BindView(R.id.movie_list_recycler)
    RecyclerView movieTitleList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.movie_list_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        searchMovieButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Button is clicked");
                String movieTitle = movieTitleText.getText().toString();
                System.out.println(movieTitle);
                passData(movieTitle);
            }
        });

        MovieListResult results = ((TransportObj)getArguments().getParcelable("FRAG_KEY"))
                .getMovieListResult();

        MovieListAdapter movieListAdapter = new MovieListAdapter(results);
        movieTitleList.setLayoutManager(new LinearLayoutManager(getContext()));
        movieTitleList.setAdapter(movieListAdapter);
    }

    public interface PassMovieData{
        void passMovieData(String data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        movieDataPasser = (PassMovieData) context;
    }

    public void passData(String data){
        movieDataPasser.passMovieData(data);
    }

}
