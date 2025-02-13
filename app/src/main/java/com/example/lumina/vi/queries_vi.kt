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

class QueriesVi : AppCompatActivity() {

    private lateinit var profile: ImageView
    private lateinit var home: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_queries_vi)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.query_vi)) { v, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        profile = findViewById(R.id.ivProfile)
        home = findViewById(R.id.ivHome)

        home.setOnClickListener {
            // Create an Intent to start VIActivity
            val intent = Intent(this@QueriesVi, VIActivity::class.java)
            startActivity(intent)
        }

        profile.setOnClickListener {
            // Create an Intent to start ProfileActivityVi
            val intent = Intent(this@QueriesVi, ProfileActivityVi::class.java)
            startActivity(intent)
        }
    }
}
