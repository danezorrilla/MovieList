package com.bb.movielist.network;

import com.bb.movielist.model.MovieListResult;
import com.bb.movielist.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieListRetrofit {

    private MovieListService movieListService;

    public MovieListRetrofit() {
        movieListService = createService(createRetrofit());
    }

    private Retrofit createRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private MovieListService createService(Retrofit retrofit){
        return retrofit.create(MovieListService.class);
    }

    public Call<List<MovieListResult>>getMovieTitle(String movieTitle){
        return movieListService.getMovieTitle(movieTitle);
    }
}
