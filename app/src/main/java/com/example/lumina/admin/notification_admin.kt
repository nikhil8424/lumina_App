package com.example.lumina.admin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lumina.R
import com.google.firebase.database.*

class NotificationAdmin : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NotificationAdapterAdmin
    private lateinit var notificationList: MutableList<NotificationItemViewsAdmin>
    private lateinit var profile: ImageView
    private lateinit var home: ImageView
    private lateinit var database: DatabaseReference

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_admin)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.notification_admin)) { view, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recycleview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        database = FirebaseDatabase.getInstance().getReference("Exams")

        // Initialize the list and adapter
        notificationList = mutableListOf()
        // Set up the adapter
        adapter = NotificationAdapterAdmin(notificationList)
        recyclerView.adapter = adapter

        profile = findViewById(R.id.ivProfile)
        home = findViewById(R.id.ivHome)

        listenForDatabaseChanges()

        profile.setOnClickListener {
            val intent = Intent(this@NotificationAdmin, ProfileActivityAdmin::class.java)
            startActivity(intent)
        }

        home.setOnClickListener {
            val intent = Intent(this@NotificationAdmin, AdminActivity::class.java)
            startActivity(intent)
        }
    }

    private fun listenForDatabaseChanges() {
        database.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
                // Retrieve new notification data from the snapshot
                val notificationItem = dataSnapshot.getValue(NotificationItemViewsAdmin::class.java)

                // Add the notification to the list and notify the adapter
                if (notificationItem != null) {
                    notificationList.add(notificationItem)
                    adapter.notifyItemInserted(notificationList.size - 1)
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
}
}
