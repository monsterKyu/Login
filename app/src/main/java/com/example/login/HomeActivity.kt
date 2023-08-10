package com.example.login

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private val imageResources = arrayOf(
        R.drawable.agumon, R.drawable.skullgreymon, R.drawable.greymon, R.drawable.metalgreymon,
        R.drawable.wargreymon
        // Add more image resource IDs here
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val username = intent.getStringExtra("username")
        val textView = findViewById<TextView>(R.id.Id_input)
        textView.text = username

        val imageView = findViewById<ImageView>(R.id.imageView)
        val randomImageResource = imageResources.random()
        imageView.setImageResource(randomImageResource)

        val btnExit = findViewById<Button>(R.id.btn_exit)
        btnExit.setOnClickListener {
            finish()
        }
    }
}