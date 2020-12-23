package com.cookandroid.mvvm_ex2.data.api

import com.cookandroid.mvvm_ex2.data.vo.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDBInterface {

    // https://api.themoviedb.org/3/movie/popular?api_key=430c5c666565d72ff34e447c2bce595d&page=1
    // https://api.themoviedb.org/3/movie/299534?api_key=430c5c666565d72ff34e447c2bce595d
    // https://api.themoviedb.org/3/

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id")id: Int): Single<MovieDetails>

}