package com.example.gifapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// terofit make dynamic quaery - (динамічний запит - який змінюється)

//@GET("group/{id}/users")
//Call<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);

interface ApiInterface {

    @GET("3/movie/popular")
    fun getMovies(@Query ("api_key")sort: String): Call<MoviesDataClass>

    companion object {
        val BASE_URL = "https://api.themoviedb.org/"
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}