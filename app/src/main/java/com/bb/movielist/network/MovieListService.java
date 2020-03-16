package com.bb.movielist.network;


import com.bb.movielist.model.MovieListResult;
import com.bb.movielist.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieListService {
    String API_KEY = Constants.API_KEY;

    @GET("/search/movie?api_key=" + API_KEY + "&language=en-US&query={movieTitle}")
    public Call<List<MovieListResult>>getMovieTitle(@Path("movieTitle")String movieTitle);
}
