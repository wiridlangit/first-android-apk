package com.dicoding.idcampdicoding

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ContactDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CONTACT_NAME = "extra_contact_name"
        const val EXTRA_CONTACT_PHONE = "extra_contact_phone"
        const val EXTRA_CONTACT_PROFILE_PICTURE = "extra_contact_profile_picture"
        const val EXTRA_CONTACT_DESCRIPTION = "extra_contact_description"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val imageViewBack: ImageView = findViewById(R.id.imageViewBack)
        imageViewBack.setOnClickListener {
            onBackPressed()
        }

        val textTitle: TextView = findViewById(R.id.textTitle)
        val imageViewProfilePicture: ImageView = findViewById(R.id.imageViewProfilePicture)
        val textContactPhone: TextView = findViewById(R.id.textContactPhone)
        val textDescription: TextView = findViewById(R.id.textDescription)

        val contactName = intent.getStringExtra(EXTRA_CONTACT_NAME)
        val contactPhone = intent.getStringExtra(EXTRA_CONTACT_PHONE)
        val contactProfilePicture = intent.getIntExtra(EXTRA_CONTACT_PROFILE_PICTURE, R.drawable.dummy_profile_picture)
        val contactDescription = intent.getStringExtra(EXTRA_CONTACT_DESCRIPTION)

        textTitle.text = "About $contactName"
        imageViewProfilePicture.setImageResource(contactProfilePicture)
        textContactPhone.text = contactPhone
        textDescription.text = contactDescription
    }
}
