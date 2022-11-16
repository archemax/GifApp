package com.example.gifapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OneMovieActivity : AppCompatActivity() {

    private lateinit var title: TextView
    private lateinit var banner: ImageView
    private lateinit var overview: TextView
    private lateinit var movieid: TextView
    private lateinit var releaseDate: TextView
    private lateinit var score: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_movie)

        title = findViewById(R.id.one_movie_layout_movieName)
        banner = findViewById(R.id.one_movie_layout_moviePoster)
        overview = findViewById(R.id.one_movie_layout_overview)
        movieid = findViewById(R.id.one_movie_layout_movieid)
        releaseDate = findViewById(R.id.one_movie_layout_releaseDate)
        score = findViewById(R.id.one_movie_layout_score)

        // receive intent from MA and get id of the movie
        val id = intent.getIntExtra("id", 0)
        Log.d("MyLog", "This is nOneMovieActivity. Movie id is: $id")

        // next change Api Interface to get the movie by it's id

        val apiInterface =
            id.let { ApiInterface.create().getMovieDetails(it, "67415281bcbc377c6203e656876fa57e") }
        apiInterface.enqueue(object : Callback<MovieDetails> {
            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {

                Log.d("MovieDetailsLog", "this is RESPONSE from OneMovieActitvity: $response")
                Log.d("MovieDetailsLog", "this is CODE from OneMovieActitvity: ${response.code()}")
                Log.d("MovieDetailsLog", "this is HEADERS from OneMovieActitvity: ${response.headers()}")



                title.text = response.body()?.title
                overview.text = response.body()?.overview
                movieid.text = response.body()?.id.toString()
                releaseDate.text = response.body()?.release_date
                score.text = response.body()?.vote_average.toString()


                Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500" + response.body()?.backdrop_path)
                    .into(banner)

            }

            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                Log.d("MovieDetailsLog", "this is error: ${t.message}")
            }
        })
    }
}