package com.example.lumina.vi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lumina.R

class VIActivity : AppCompatActivity() {

    private lateinit var notification: Button
    private lateinit var queries: Button
    private lateinit var help: Button
    private lateinit var profile: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_vi)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.vi)) { v, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        notification = findViewById(R.id.button5)
        queries = findViewById(R.id.button6)
        help = findViewById(R.id.button7)
        profile = findViewById(R.id.ivProfile)

        notification.setOnClickListener {
            // Create an Intent to start NotificationVi
            val intent = Intent(this@VIActivity, NotificationVi::class.java)
            startActivity(intent)
        }

        queries.setOnClickListener {
            // Create an Intent to start QueriesVi
            val intent = Intent(this@VIActivity, QueriesVi::class.java)
            startActivity(intent)
        }

        help.setOnClickListener {
            // Create an Intent to start HelpResourcesVI
            val intent = Intent(this@VIActivity, HelpResourcesVI::class.java)
            startActivity(intent)
        }

        profile.setOnClickListener {
            // Create an Intent to start ProfileActivityVi
            val intent = Intent(this@VIActivity, ProfileActivityVi::class.java)
            startActivity(intent)
        }
    }
}
