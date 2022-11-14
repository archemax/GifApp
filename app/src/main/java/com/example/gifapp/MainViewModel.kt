package com.example.gifapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val apiInterface = ApiInterface.create().getMovies("67415281bcbc377c6203e656876fa57e")
    val moviesLiveData = MutableLiveData<List<MovieResponse>>()

    // gets the data from API and starts the method when ViewModel calss is initialized

    init {
        getMovieData()
    }


    private fun getMovieData() {
        apiInterface.enqueue(object : Callback<MoviesDataClass> {

            override fun onResponse(
                call: Call<MoviesDataClass>,
                response: Response<MoviesDataClass>
            ) {
                moviesLiveData.value = response.body()?.results
                Log.d("MyLog", "this is responce from ViewModel: ${response.body()?.results}")

                // how to pass data to viewModel??????
            }

            override fun onFailure(call: Call<MoviesDataClass>, t: Throwable) {
                Log.d("MyLog", "this is error: $t")
            }
        })
    }

    // передати сюди дані з API??????

}


////////////////////////////////////////////////////////////////////////////////////////////////
/// paste data fron API here

