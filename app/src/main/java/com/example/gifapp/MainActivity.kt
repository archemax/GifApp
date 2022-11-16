package com.example.gifapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.gifapp.UsersAdapter.ItemClickListener
import com.example.gifapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val usersAdapter = UsersAdapter(this@MainActivity, object : ItemClickListener {
            override fun onItemClick(id: Int) {
                Toast.makeText(this@MainActivity, "the ID of the movie $id", Toast.LENGTH_SHORT).show()
                // make intent to go to the other actiivity
                val intent = Intent (this@MainActivity, OneMovieActivity::class.java)
                intent.putExtra("id", id)
                startActivity(intent)
            }
        })
        val recyclerView: RecyclerView = findViewById(R.id.RVMainActivity_layout)

        //назначаємо адаптер для RV
        recyclerView.adapter = usersAdapter

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //робимо observe даних
        viewModel.moviesLiveData.observe(this) { movies ->
            Log.d("MyLog", "In MainActivity ${movies.size}")
            //adding data to adapter
            usersAdapter.addMovies(movies)

        }
    }
}










