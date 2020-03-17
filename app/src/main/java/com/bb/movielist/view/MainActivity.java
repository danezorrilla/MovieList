package com.bb.movielist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bb.movielist.R;
import com.bb.movielist.model.MovieListResult;
import com.bb.movielist.model.Result;
import com.bb.movielist.model.TransportObj;
import com.bb.movielist.network.MovieListRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MovieListFragment.PassMovieData {

    private MovieListRetrofit movieListRetrofit = new MovieListRetrofit();

    private MovieListFragment movieListFragment = new MovieListFragment();
    private MovieDetailFragment movieDetailFragment = new MovieDetailFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getMovieList("James Bond");
    }

    private void getMovieList(String movieTitle){
        movieListRetrofit.getMovieTitle(movieTitle)
                .enqueue(new Callback<MovieListResult>() {
                    @Override
                    public void onResponse(Call<MovieListResult> call, Response<MovieListResult> response) {
                        Log.d("TAG_X", call.request().url()+"");
                        if(response.isSuccessful() && response.body() != null){
                            showMovieList(response.body());
                            //onOpenFragment();
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieListResult> call, Throwable t) {
                        Log.d("TAG_X failed", call.request().url()+" "+t.getLocalizedMessage());
                    }
                });
    }

//    public void onOpenFragment(){
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.movie_list_frame, movieListFragment)
//                .commit();
//    }

    public void showMovieList(MovieListResult movieList){
        Bundle bundle = new Bundle();
        TransportObj transportObj = new TransportObj(movieList);
        bundle.putParcelable("FRAG_KEY", transportObj);
        movieListFragment = new MovieListFragment();
        movieListFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.movie_list_frame, movieListFragment)
                .commit();
    }

    @Override
    public void passMovieData(String data) {

    }
}
