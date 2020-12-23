package com.cookandroid.mvvm_ex2.single_movie_details

import android.net.Network
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cookandroid.mvvm_ex2.data.repository.NetworkState
import com.cookandroid.mvvm_ex2.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class SingleMovieViewModel(private val movieRepository: MovieDetailsRepository, movieId: Int) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val movieDetails: LiveData<MovieDetails> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable, movieId)
    }

    val networkState: LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}