package com.example.gifapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.gifapp.databinding.ActivityMainBinding

// implement interface fro UsersAdapter class
class MainActivity : AppCompatActivity(),
    UsersAdapter.OnItemClickListenerImpl {

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
        adapterMainActivity = UsersAdapter(this, this)
        recyclerView.adapter = adapterMainActivity
        adapterMainActivity.setList(addListToRV())


    }

    // this is the implementation of fun form adapter's Interface
    override fun onItemClicked(position: Int) {
        Toast.makeText(this, "item $position CLICKED", Toast.LENGTH_SHORT).show()


        val newList = addListToRV()
        val intent = Intent(this, ShowInfoActivity::class.java)

            .putExtra("keyName", newList[position].name)
            .putExtra("keyDesc", newList[position].description)
            .putExtra("keyPicture", newList[position].picture)
        ContextCompat.startActivity(this, intent, null)
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    fun addListToRV(): ArrayList<ItemDataClass> {
        val userList = ArrayList<ItemDataClass>()

        val user1 = ItemDataClass(R.drawable.user_1_pic, "Bob", "Marley")
        userList.add(user1)
        val user2 = ItemDataClass(R.drawable.user_2_pic, "Elvis", "Prestley")
        userList.add(user2)
        val user3 = ItemDataClass(R.drawable.user_3_pic, "Charlie", "Dylan")
        userList.add(user3)
        val user4 = ItemDataClass(R.drawable.user_3_pic, "Jack", "Dylan")
        userList.add(user4)
        val user5 = ItemDataClass(R.drawable.user_3_pic, "Bill", "Dylan")
        userList.add(user5)
        val user6 = ItemDataClass(R.drawable.user_3_pic, "Jay", "Dylan")
        userList.add(user6)

        return userList
    }


}