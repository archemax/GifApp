package com.example.gifapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.gifapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapterMainActivity: UsersAdapter // create adapter in MainActivity
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // creating method to initialize recView
        initialize()

    }

    private fun initialize() {
        recyclerView = binding.RVMainActivity
        adapterMainActivity = UsersAdapter(this)
        recyclerView.adapter = adapterMainActivity
        adapterMainActivity.setList(addListToRV())
    }

    fun addListToRV(): ArrayList<ItemDataClass>{
        val userList = ArrayList<ItemDataClass>()

        val user1 = ItemDataClass(R.drawable.user_1_pic, "Bob", "Marley")
        userList.add(user1)

        val user2 = ItemDataClass(R.drawable.user_2_pic, "Elvis", "Prestley")
        userList.add(user2)

        val user3 = ItemDataClass(R.drawable.user_3_pic, "Bob", "Dylan")
        userList.add(user3)
        val user4 = ItemDataClass(R.drawable.user_3_pic, "Bob", "Dylan")
        userList.add(user4)
        val user5 = ItemDataClass(R.drawable.user_3_pic, "Bob", "Dylan")
        userList.add(user5)
        val user6 = ItemDataClass(R.drawable.user_3_pic, "Bob", "Dylan")
        userList.add(user6)

        return userList
    }
}