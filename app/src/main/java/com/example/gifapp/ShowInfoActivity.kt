package com.example.gifapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_info.*

class ShowInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_info)

        // receive data fron intent



        val name = intent.getStringExtra("keyName") // only key from RVAdapter


        // show data in the ytext view
        textViewFinal.text = name


    }
}