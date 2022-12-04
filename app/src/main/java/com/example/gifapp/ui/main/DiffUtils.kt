package com.example.gifapp.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.example.gifapp.data.response.MovieResponse

class MyDiffUtil(
    private val oldList: List<MovieResponse>,
    private val newList: List<MovieResponse>
) : DiffUtil.Callback(){
    override fun getOldListSize(): Int { return oldList.size }
    override fun getNewListSize(): Int { return newList.size }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // "===" check if the itrems are identical
        // only if this method returns true -> areContentsThe same method is called
        return oldList[oldItemPosition] === newList[newItemPosition]
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       // here we compare CONTENT between two lists
        return oldList[oldItemPosition].id == newList[newItemPosition].id
                && oldList[oldItemPosition].title == newList[newItemPosition].title
                && oldList[oldItemPosition].overview == newList[newItemPosition].overview
                && oldList[oldItemPosition].release_date == newList[newItemPosition].release_date
    }
}