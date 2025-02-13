package com.example.lumina.writer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lumina.R

class ProfileActivityWriter : ComponentActivity() {

    private lateinit var home: ImageView
    private lateinit var profile: ImageView
    private lateinit var settings: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // EdgeToEdge.enable(this) // Uncomment if you can resolve EdgeToEdge or remove this line if not needed
        setContentView(R.layout.profile_writer)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile_writer)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        home = findViewById(R.id.ivHome)
        profile = findViewById(R.id.ivProfile)
        settings = findViewById(R.id.ivSetting)

        home.setOnClickListener {
            val intent = Intent(this, WriterActivity::class.java)
            startActivity(intent)
        }

        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivityWriter::class.java)
            startActivity(intent)
        }
    }
}
