package com.bb.movielist.network;


import com.bb.movielist.model.MovieListResult;
import com.bb.movielist.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieListService {

    @GET("/3/search/movie")
    public Call<MovieListResult>getMovieTitle(@Query("api_key") String apiKey,
                                                    @Query("query") String query);
}
