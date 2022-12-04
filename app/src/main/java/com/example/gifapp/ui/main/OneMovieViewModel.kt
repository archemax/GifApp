package com.example.gifapp.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gifapp.data.response.MovieResponse
import com.example.gifapp.data.response.MoviesDataClass
import com.example.gifapp.data.retrofit.ApiInterface
import com.example.gifapp.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OneMovieViewModel : ViewModel() {

    // pass movie Id here
    fun setMovieId(id: Int) {}


    val oneMovieLiveData = MutableLiveData<MovieResponse>()
    private val apiInterface = ApiInterface.create()


    fun getOneMovieData(id: Int) {
        apiInterface.getMovieDetails(id, Constants.API_KEY)
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    oneMovieLiveData.value = response.body()
                    Log.d("MyLog", "this is response from OneMovieViewModel${response.body()}")

                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d("MyLog", "this is error in OnMovieViewModel${t.message}")
                }
            })
    }
}