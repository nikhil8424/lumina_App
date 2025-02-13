package com.example.lumina.admin

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lumina.R

class HelpAdmin : AppCompatActivity() {

    private lateinit var home: ImageView
    private lateinit var profile: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_help_admin)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.help_admin)) { v, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        home = findViewById(R.id.ivHome)
        profile = findViewById(R.id.ivProfile)

        home.setOnClickListener {
            val intent = Intent(this@HelpAdmin, AdminActivity::class.java)
            startActivity(intent)
        }

        profile.setOnClickListener {
            val intent = Intent(this@HelpAdmin, ProfileActivityAdmin::class.java)
            startActivity(intent)
        }
    }
}
