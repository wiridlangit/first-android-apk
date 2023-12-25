package com.dicoding.idcampdicoding

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val imageViewBack: ImageView = findViewById(R.id.imageViewBack)
        imageViewBack.setOnClickListener {
            onBackPressed()
        }

        val imageViewProfile: ImageView = findViewById(R.id.imageViewProfile)
        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewEmail: TextView = findViewById(R.id.textViewEmail)

        imageViewProfile.setImageResource(R.drawable.profile_picture)
        textViewName.text = "Wiridlangit Suluh Jiwangga"
        textViewEmail.text = "example@gmail.com"

    }
}

