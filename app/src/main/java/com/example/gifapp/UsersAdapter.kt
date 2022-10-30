package com.example.gifapp

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.one_item_layout.view.*

// this is adapter for recycler view
// create a ViewHolder inner  class  adapter class
//A ViewHolder describes an item view and metadata about its place within the RecyclerView.


class UsersAdapter(
    private val context: Context,
    //add link to MainActivity
    private val listener: OnItemClickListenerImpl
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
    // this method is called over and over again
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.imageView.setImageResource(currentItem.picture)
        holder.textViewName.text = currentItem.name
        holder.textViewDescription.text = currentItem.description

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
    // here we cache all the views for one item in RV
    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view),
        OnClickListener {

        // use syntetic property here OR findViewById
        val imageView: ImageView = view.findViewById(R.id.myImageView)
        val textViewName: TextView = view.findViewById(R.id.myTvName)
        val textViewDescription: TextView = view.findViewById(R.id.myTvDescription)


        // set onClickListener here on the whole view (view)

        //1) create init{} block and connect onClickListener to view (in class ItemViewHolder)
        //2) implement OnclickListener interface
        //3) implement onClick method from OnClickListener Interface (CTRL + I)
        //move the onCLick code to MainActivity
        init {
            view.setOnClickListener(this) // this -> is an ItemViewHolder class
        }
        override fun onClick(v: View?) {
            //this is listener from Adapter class
            val position123 = adapterPosition  // шось старе
            //check if the position is valid
            if (position123 != RecyclerView.NO_POSITION) {
                listener.onItemClicked(position123)
            }

        }
        }
    interface OnItemClickListenerImpl{
        fun onItemClicked(position: Int)
    }
}




