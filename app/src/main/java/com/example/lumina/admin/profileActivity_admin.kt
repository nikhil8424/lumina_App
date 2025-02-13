package com.example.lumina.admin

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lumina.R

class ProfileActivityAdmin : ComponentActivity() {

    private lateinit var home: ImageView
    private lateinit var profile: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_admin)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile_admin)) { view, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        home = findViewById(R.id.ivHome)
        profile = findViewById(R.id.ivProfile)

        home.setOnClickListener {
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
        }
    }
}
