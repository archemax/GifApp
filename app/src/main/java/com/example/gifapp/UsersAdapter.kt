package com.example.gifapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import retrofit2.Callback

// this is adapter for recycler view
// create a ViewHolder inner  class  adapter class
//A ViewHolder describes an item view and metadata about its place within the RecyclerView.

class UsersAdapter(
    private val context: MainActivity,
    val mItemClickListener: ItemClickListener
) : RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {

    ///////itenClickInterface/////////////////////////////////////////////
    interface ItemClickListener {
        fun onItemClick(position: Int)
    }

    ///////////////////////////////////////////////////////////////////


    inner class MyViewHolder(oneItemView: View) : RecyclerView.ViewHolder(oneItemView) {
        // тут звязуємо розмітку
        val textViewMovieName: TextView = oneItemView.findViewById(R.id.myTvName)
        val imageView: ImageView = oneItemView.findViewById(R.id.myImageView)

        // ititialize click listener interface
        init {
            oneItemView.setOnClickListener {
                movies.get(position).id.let { movieId -> mItemClickListener.onItemClick(movieId) }

            }
        }

    }

    // create a list to put the data
    private val movies = mutableListOf<MovieResponse>()

    fun addMovies(list: List<MovieResponse>) {
        movies.addAll(list)
        notifyDataSetChanged()
    }

    // in this fun we will pass the layout for one item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.one_item_layout, parent, false)
        return MyViewHolder(view)
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //тут передаємо дані в окремі поля елемента списку
        holder.textViewMovieName.text = movies[position].title

        // тут передаємо картинку the link is concatination of strings
        Picasso.get().load("https://image.tmdb.org/t/p/w500" + movies.get(position).poster_path)
            .into(holder.imageView)
    }

    // this fun returns the number of elements in list
    override fun getItemCount(): Int {
        return movies.size
    }
}








