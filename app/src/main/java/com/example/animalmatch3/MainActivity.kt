package com.example.animalmatch3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton: ImageButton = findViewById(R.id.playbutton)
        playButton.setOnClickListener {
            // Start the gameplay activity when the button is clicked
            startActivity(Intent(this, gameplay::class.java))
        }
    }
}
