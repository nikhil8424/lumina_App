package com.example.lumina.writer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lumina.R

class FeedbackWriters : AppCompatActivity() {

    private lateinit var profile: ImageView
    private lateinit var home: ImageView
    private lateinit var settings: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.feedback_writers)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.feedback_writers)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        profile = findViewById(R.id.ivProfile)
        home = findViewById(R.id.ivHome)
        settings = findViewById(R.id.ivSetting)

        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivityWriter::class.java)
            startActivity(intent)
        }

        home.setOnClickListener {
            val intent = Intent(this, WriterActivity::class.java)
            startActivity(intent)
        }
    }
}
