package com.example.gifapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val usersLiveData = MutableLiveData<ArrayList<ItemDataClass>>()

    init {
        createMockData()
    }

    fun createMockData() {
        val usersDada = getUsersList()
        usersLiveData.value = usersDada
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    fun getUsersList(): ArrayList<ItemDataClass> {
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