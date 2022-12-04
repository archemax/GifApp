package com.example.gifapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gifapp.data.retrofit.ApiInterface
import com.example.gifapp.R
import com.example.gifapp.data.response.MovieResponse
import com.example.gifapp.utils.Constants
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OneMovieActivity : AppCompatActivity() {

    lateinit var viewModel: OneMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_movie)

        val title: TextView = findViewById(R.id.one_movie_layout_movieName)
        val banner: ImageView = findViewById(R.id.one_movie_layout_moviePoster)
        val overview: TextView = findViewById(R.id.one_movie_layout_overview)
        val movieid: TextView = findViewById(R.id.one_movie_layout_movieid)
        val releaseDate: TextView = findViewById(R.id.one_movie_layout_releaseDate)
        val score: TextView = findViewById(R.id.one_movie_layout_score)

        val id = intent.getIntExtra(MOVIE_ID, 0)

        //create viewModel
        val viewModel = ViewModelProvider(this).get(OneMovieViewModel::class.java)
        viewModel.getOneMovieData(id)

        // create LiveData
        viewModel.oneMovieLiveData.observe(this) { myMovieResponse ->
            title.text = myMovieResponse.title
            overview.text = myMovieResponse.overview
            movieid.text = myMovieResponse.id.toString()
            releaseDate.text = myMovieResponse.release_date
            score.text = myMovieResponse.popularity.toString()
            Picasso.get().load("https://image.tmdb.org/t/p/w500" + myMovieResponse.backdrop_path)
                .into(banner)

        }




        Log.d("MyLog", "This is OneMovieActivity. Movie id is: $id")

//        val apiInterface =
//            id.let { ApiInterface.create().getMovieDetails(it, Constants.API_KEY) }
//        apiInterface.enqueue(object : Callback<MovieResponse> {
//            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
//                title.text = response.body()?.title
//                overview.text = response.body()?.overview
//                movieid.text = response.body()?.id.toString()
//                releaseDate.text = response.body()?.release_date
//                score.text = response.body()?.vote_average.toString()
//                Picasso.get()
//                    .load("https://image.tmdb.org/t/p/w500" + response.body()?.backdrop_path)
//                    .into(banner)
//            }
//
//            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//                Log.d("MovieDetailsLog", "this is error: ${t.message}")
//            }
//        })

    }

    companion object {
        const val MOVIE_ID = "myName"
    }

}