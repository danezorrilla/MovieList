package com.bb.movielist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bb.movielist.R;

public class MainActivity extends AppCompatActivity {

    private MovieListFragment movieListFragment = new MovieListFragment();
    private MovieDetailFragment movieDetailFragment = new MovieDetailFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onOpenFragment();
    }

    private void getMovieTitle(){

    }

    public void onOpenFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.movie_list_frame, movieListFragment)
                .commit();
    }

}
