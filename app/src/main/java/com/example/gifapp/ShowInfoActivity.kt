package com.example.gifapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_info.*

class ShowInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_info)

        // receive data fron intent



        val name = intent.getStringExtra("keyName") // only key from RVAdapter
        val decsription = intent.getStringExtra("keyDesc")
        val picture = intent.getIntExtra("keyPicture",R.drawable.user_1_pic)




        // show data in the ytext view
        textViewFinalName.text = name
        textViewFinalDesc.text = decsription
        imageViewFinal.setImageResource(picture)



    }
}