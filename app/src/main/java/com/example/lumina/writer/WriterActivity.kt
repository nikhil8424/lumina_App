package com.example.lumina.writer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lumina.R

class WriterActivity : ComponentActivity() {

    private lateinit var availability: Button
    private lateinit var notification: Button
    private lateinit var queries: Button
    private lateinit var help: Button
    private lateinit var profile: ImageView
    private lateinit var home: ImageView
    private lateinit var settings: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_writer)

//        val rootView = findViewById<View>(R.id.activity_writer)
//        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }


        availability = findViewById(R.id.button3)
        notification = findViewById(R.id.button4)
        queries = findViewById(R.id.button8)
        help = findViewById(R.id.button9)
//        profile = findViewById(R.id.ivProfile)
//        home = findViewById(R.id.ivHome)
//        settings = findViewById(R.id.ivSetting)

        availability.setOnClickListener {
            val intent = Intent(this, AvailabilityWriters::class.java)
            startActivity(intent)
        }

        notification.setOnClickListener {
            val intent = Intent(this, NotificationWriter::class.java)
            startActivity(intent)
        }

        queries.setOnClickListener {
            val intent = Intent(this, WriterActivity::class.java)
            startActivity(intent)
        }

        help.setOnClickListener {
            val intent = Intent(this, HelpResourcesWriters::class.java)
            startActivity(intent)
        }

//        profile.setOnClickListener {
//            val intent = Intent(this, ProfileActivityWriter::class.java)
//            startActivity(intent)
//        }
//
//        home.setOnClickListener {
//            val intent = Intent(this, WriterActivity::class.java)
//            startActivity(intent)
//       }
    }
}
