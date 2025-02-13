package com.example.lumina.writer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lumina.R

class HelpResourcesWriters : AppCompatActivity() {

    private lateinit var feedback: Button
    private lateinit var profile: ImageView
    private lateinit var home: ImageView
    private lateinit var settings: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_help_resources_writers)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.help_resources_writers)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        feedback = findViewById(R.id.feedback)
        profile = findViewById(R.id.ivProfile)
        home = findViewById(R.id.ivHome)
        settings = findViewById(R.id.ivSetting)

        feedback.setOnClickListener {
            val intent = Intent(this, FeedbackWriters::class.java)
            startActivity(intent)
        }

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
