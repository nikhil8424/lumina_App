package com.example.lumina.vi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lumina.R

class HelpResourcesVI : ComponentActivity() {

    private lateinit var feedback: Button
    private lateinit var profile: ImageView
    private lateinit var home: ImageView
    private lateinit var settings: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_resources_vi)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.help_resources_VI)) { view, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        feedback = findViewById(R.id.feedback)
        profile = findViewById(R.id.ivProfile)
        home = findViewById(R.id.ivHome)
        settings = findViewById(R.id.ivSetting)

        feedback.setOnClickListener {
            val intent = Intent(this, FeedbackVI::class.java)
            startActivity(intent)
        }

        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivityVi::class.java)
            startActivity(intent)
        }

        home.setOnClickListener {
            val intent = Intent(this, VIActivity::class.java)
            startActivity(intent)
        }
    }
}
