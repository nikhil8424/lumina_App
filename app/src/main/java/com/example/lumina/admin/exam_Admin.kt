package com.example.lumina.admin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lumina.ExamSchedule
import com.example.lumina.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ExamAdmin : AppCompatActivity() {

    private lateinit var profile: ImageView
    private lateinit var home: ImageView
    private lateinit var addButton: Button
    private lateinit var database:  DatabaseReference
    private lateinit var adapter: DataAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_exam)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.admin_exam)) { v, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        database = FirebaseDatabase.getInstance().getReference("Exams")

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchDataFromFirebase()

        profile = findViewById(R.id.ivProfile)
        home = findViewById(R.id.ivHome)
        addButton = findViewById(R.id.addButton)

        profile.setOnClickListener {
            val intent = Intent(this@ExamAdmin, ProfileActivityAdmin::class.java)
            startActivity(intent)
        }

        home.setOnClickListener {
            val intent = Intent(this@ExamAdmin, AdminActivity::class.java)
            startActivity(intent)
        }

        addButton.setOnClickListener {
            val intent = Intent(this@ExamAdmin, AddExam::class.java)
            startActivity(intent)
        }
    }

    private fun fetchDataFromFirebase() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val dataList = mutableListOf<ExamSchedule>()

                for (dataSnapshot in snapshot.children) {
                    // Deserialize each child as an ExamSchedule object
                    val examSchedule = dataSnapshot.getValue(ExamSchedule::class.java)

                    // Only add non-null exam schedules to the list
                    if (examSchedule != null) {
                        dataList.add(examSchedule)
                    }
                }

                // Initialize and set the RecyclerView adapter
                adapter = DataAdapter(dataList)
                recyclerView.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase", "Failed to read data", error.toException())
            }
        })
    }


}
