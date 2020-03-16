package com.bb.movielist.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.bb.movielist.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListFragment extends Fragment {

    @BindView(R.id.movie_title)
    EditText movieTitleText;

    @BindView(R.id.search_movie)
    Button searchMovieButton;

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
            }
        });
    }

}
