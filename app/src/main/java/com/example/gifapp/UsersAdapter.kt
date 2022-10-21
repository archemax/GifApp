package com.example.gifapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.one_item_layout.view.*

// this is adapter for recycler view
// create a ViewHolder inner  class  adapter class
//A ViewHolder describes an item view and metadata about its place within the RecyclerView.
class UsersAdapter(
    private val context: Context
) : RecyclerView.Adapter<UsersAdapter.ItemViewHolder>() {


    // create a list to put the data
    private val userList = mutableListOf<ItemDataClass>()




    // in this fun we will pass the layout fro one item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.one_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    // add id 'kotlin-android-extensions' to build.gradle to see the layout
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.TVName.text = userList[position].name
        holder.itemView.TVDescription.text = userList[position].description
        holder.itemView.myImageView.setImageResource(userList[position].picture) // але треба різні картинки


        // click
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "position:  $position", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, ShowInfoActivity::class.java)
                .putExtra("keyName", userList[position].name)





            startActivity(context, intent, null)


        }
    }
    // this fun returns the number of elements in list
    override fun getItemCount(): Int {
        return userList.size
    }

    //this fun sets the list from MainActivity
    fun setList(list: List<ItemDataClass>) {
        userList.addAll(list)
        notifyDataSetChanged() // if the data changes - it will update adapter
    }

    //this is ViewHolder. We create ViewHolder as nested class in adapter
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {}







}




