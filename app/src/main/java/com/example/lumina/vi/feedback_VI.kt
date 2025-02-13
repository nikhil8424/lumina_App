package com.example.lumina.vi

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lumina.R

class FeedbackVI : ComponentActivity() {

    private lateinit var profile: ImageView
    private lateinit var home: ImageView
    private lateinit var settings: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feedback_vi)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.feedback_vi)) { view, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        profile = findViewById(R.id.ivProfile)
        home = findViewById(R.id.ivHome)
        settings = findViewById(R.id.ivSetting)

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
