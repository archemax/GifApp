package com.example.gifapp.ui.main.mainActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.gifapp.R
import com.example.gifapp.ui.main.UsersAdapter.ItemClickListener
import com.example.gifapp.databinding.ActivityMainBinding
import com.example.gifapp.ui.main.oneMovieActivity.OneMovieActivity
import com.example.gifapp.ui.main.UsersAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        val usersAdapter = UsersAdapter(this@MainActivity, object : ItemClickListener {
            override fun onItemClick(id: Int) {
                Toast.makeText(this@MainActivity, "the ID of the movie $id", Toast.LENGTH_SHORT)
                    .show()
                // make intent to go to the other actiivity
                val intent = Intent(this@MainActivity, OneMovieActivity::class.java)
                intent.putExtra(OneMovieActivity.MOVIE_ID, id)
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
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.top_rated -> {
                Toast.makeText(this, "this is top rated",Toast.LENGTH_LONG).show()
            }
            R.id.popular ->{
                Toast.makeText(this, "this is top popular",Toast.LENGTH_LONG).show()
            }
            R.id.upcoming ->{
                Toast.makeText(this, "this is top upcoming",Toast.LENGTH_LONG).show()
            }
        }
        return true
    }
}









