package com.cookandroid.mvvm_ex2.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.cookandroid.mvvm_ex2.data.api.TheMovieDBInterface
import com.cookandroid.mvvm_ex2.data.repository.MovieDetailsNetworkDataSource
import com.cookandroid.mvvm_ex2.data.repository.NetworkState
import com.cookandroid.mvvm_ex2.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService: TheMovieDBInterface) {
    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetails> {
        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }
}