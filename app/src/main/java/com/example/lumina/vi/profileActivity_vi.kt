package com.example.lumina.vi

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lumina.R

class ProfileActivityVi : AppCompatActivity() {

    private lateinit var home: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.profile_vi)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile_vi)) { v, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        home = findViewById(R.id.ivHome)
        home.setOnClickListener {
            // Create an Intent to start VIActivity
            val intent = Intent(this@ProfileActivityVi, VIActivity::class.java)
            startActivity(intent)
        }
    }
}
