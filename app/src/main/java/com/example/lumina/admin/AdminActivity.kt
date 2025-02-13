package com.example.lumina.admin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lumina.R
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.lumina.R.*

class AdminActivity : AppCompatActivity() {
    private lateinit var notification: Button
    private lateinit var exam: Button
    private lateinit var allotment: Button
    private lateinit var queries: Button
    private lateinit var manage: Button
    private lateinit var help: Button
    private lateinit var profile: ImageView
    private lateinit var home: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_admin)

        val rootView = findViewById<View>(id.admin)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        notification = findViewById(id.btn_notification)
        exam = findViewById(id.btn_exams)
        allotment = findViewById(id.btn_allotments)
        queries = findViewById(id.btn_queries)
        manage = findViewById(id.btn_mwriters)
        help = findViewById(id.btn_help)

        profile = findViewById(id.ivProfile)
        home = findViewById(id.ivHome)

        notification.setOnClickListener {
            val intent = Intent(this, NotificationAdmin::class.java)
            startActivity(intent)
        }

        exam.setOnClickListener {
            val intent = Intent(this, ExamAdmin::class.java)
            startActivity(intent)
        }

        allotment.setOnClickListener {
            val intent = Intent(this, AllotmentSchedule::class.java)
            startActivity(intent)
        }

        queries.setOnClickListener {
            val intent = Intent(this, QueriesAdmin::class.java)
            startActivity(intent)
        }

        manage.setOnClickListener {
            val intent = Intent(this, ManageWriters::class.java)
            startActivity(intent)
        }

        help.setOnClickListener {
            val intent = Intent(this, HelpAdmin::class.java)
            startActivity(intent)
        }

        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivityAdmin::class.java)
            startActivity(intent)
        }
    }
}
