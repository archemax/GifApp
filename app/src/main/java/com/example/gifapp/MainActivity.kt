package com.example.gifapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
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

        val usersAdapter = UsersAdapter(this@MainActivity)
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










