package com.example.lumina.vi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lumina.R
import android.view.View
import android.widget.ImageView
import java.util.ArrayList

class NotificationVi : AppCompatActivity() {

    // Initialize RecyclerView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NotificationAdapterVi
    private lateinit var notificationList: MutableList<NotificationItemViewsVi>
    private lateinit var profile: ImageView
    private lateinit var home: ImageView
    private lateinit var settings: ImageView

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_vi)

        recyclerView = findViewById(R.id.recycleview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the list and adapter
        notificationList = ArrayList()
        // Add sample notifications (in a real app, fetch from a data source)
        notificationList.add(NotificationItemViewsVi("Title 1", "Body 1", "10:00 AM"))
        notificationList.add(NotificationItemViewsVi("Title 2", "Body 2", "11:00 AM"))
        notificationList.add(NotificationItemViewsVi("Title 3", "Body 3", "12:00 PM"))
        notificationList.add(NotificationItemViewsVi("Title 4", "Body 4", "01:00 PM"))
        notificationList.add(NotificationItemViewsVi("Title 5", "Body 5", "02:00 PM"))

        // Set up the adapter
        adapter = NotificationAdapterVi(notificationList)
        recyclerView.adapter = adapter

        profile = findViewById(R.id.ivProfile)
        home = findViewById(R.id.ivHome)
        settings = findViewById(R.id.ivSetting)

        profile.setOnClickListener {
            // Create an Intent to start ProfileActivityVi
            val intent = Intent(this@NotificationVi, ProfileActivityVi::class.java)
            startActivity(intent)
        }

        home.setOnClickListener {
            // Create an Intent to start VIActivity
            val intent = Intent(this@NotificationVi, VIActivity::class.java)
            startActivity(intent)
        }
    }
}
