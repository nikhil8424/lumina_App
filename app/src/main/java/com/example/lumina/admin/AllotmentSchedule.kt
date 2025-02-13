package com.example.lumina.admin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import com.example.lumina.R

class AllotmentSchedule : AppCompatActivity() {

    private lateinit var profile: ImageView
    private lateinit var home: ImageView
    private lateinit var setting: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_allotment_schedule)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.allotment_schedule)) { v, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        profile = findViewById(R.id.ivProfile)
        home = findViewById(R.id.ivHome)
        setting = findViewById(R.id.ivSetting)

        profile.setOnClickListener {
            val intent = Intent(this@AllotmentSchedule, ProfileActivityAdmin::class.java)
            startActivity(intent)
        }

        home.setOnClickListener {
            val intent = Intent(this@AllotmentSchedule, AdminActivity::class.java)
            startActivity(intent)
        }
    }
}
