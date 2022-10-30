package com.example.gifapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.gifapp.databinding.ActivityMainBinding

// implement interface fro UsersAdapter class
class MainActivity : AppCompatActivity(),
    UsersAdapter.OnItemClickListenerImpl {

    lateinit var binding: ActivityMainBinding
    lateinit var usersAdapter: UsersAdapter // create adapter in MainActivity
    lateinit var recyclerView: RecyclerView
    // create a ViewModel
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //////////////////////////////////////////////////////////////////////////////////////
        // 1) create adapter
        usersAdapter = UsersAdapter(this, this)

        //допоміжний етап: передаємо розмітку
        binding.RVMainActivityLayout.adapter = usersAdapter
        //////////////////////////////////////////////////////////////////////////////////////
        //2) create view model
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //робимо observe даних
        viewModel.usersLiveData.observe(this) { users ->
            //щось придумав
            usersAdapter.setList(users)
        }


    }

    // this is the implementation of fun form adapter's Interface
    override fun onItemClicked(position: Int) {
        Toast.makeText(this, "item $position CLICKED", Toast.LENGTH_SHORT).show()

        val newList = viewModel.getUsersList()
        val intent = Intent(this, ShowInfoActivity::class.java)
            .putExtra("keyName", newList[position].name)
            .putExtra("keyDesc", newList[position].description)
            .putExtra("keyPicture", newList[position].picture)
        ContextCompat.startActivity(this, intent, null)
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


}