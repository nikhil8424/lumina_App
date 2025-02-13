package com.example.lumina.writer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lumina.R
import android.widget.ImageView
import java.util.ArrayList

class NotificationWriter : AppCompatActivity() {

    // Initialize RecyclerView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NotificationAdapterWriter
    private lateinit var notificationList: MutableList<NotificationItemViewWriter>
    private lateinit var profile: ImageView
    private lateinit var home: ImageView
    private lateinit var settings: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_writer)

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recycleview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the list and adapter
        notificationList = ArrayList()
        // Add sample notifications (in a real app, fetch from a data source)
        notificationList.add(NotificationItemViewWriter("Title 1", "Body 1", "10:00 AM"))
        notificationList.add(NotificationItemViewWriter("Title 2", "Body 2", "11:00 AM"))
        notificationList.add(NotificationItemViewWriter("Title 3", "Body 3", "12:00 PM"))
        notificationList.add(NotificationItemViewWriter("Title 4", "Body 4", "01:00 PM"))
        notificationList.add(NotificationItemViewWriter("Title 5", "Body 5", "02:00 PM"))

        // Set up the adapter
        adapter = NotificationAdapterWriter(notificationList)
        recyclerView.adapter = adapter

        // Initialize views
        profile = findViewById(R.id.ivProfile)
        home = findViewById(R.id.ivHome)
        settings = findViewById(R.id.ivSetting)

        // Set up click listeners
        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivityWriter::class.java)
            startActivity(intent)
        }

        home.setOnClickListener {
            val intent = Intent(this, WriterActivity::class.java)
            startActivity(intent)
        }

        settings.setOnClickListener {
            val intent = Intent(this, WriterActivity::class.java)
            startActivity(intent)
        }
    }
}
