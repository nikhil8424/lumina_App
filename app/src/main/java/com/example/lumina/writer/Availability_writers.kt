package com.example.lumina.writer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lumina.ExamSchedule
import com.example.lumina.databinding.AvailabilityWritersBinding

class AvailabilityWriters : AppCompatActivity() {

    private lateinit var binding: AvailabilityWritersBinding
    private lateinit var adapter: ExamScheduleAdapter
    private lateinit var examScheduleList: MutableList<ExamSchedule>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AvailabilityWritersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the list and adapter
        examScheduleList = mutableListOf(
            ExamSchedule("Math", "2024-08-01", "10:00 AM - 12:00 PM"),
            ExamSchedule("Physics", "2024-08-02", "10:00 AM - 12:00 PM"),
            ExamSchedule("Chemistry", "2024-08-03", "10:00 AM - 12:00 PM")
        )

        adapter = ExamScheduleAdapter(examScheduleList)
        binding.recyclerView.adapter = adapter

        // Set up click listeners
//        binding.ivProfile.setOnClickListener {
//            val intent = Intent(this, ProfileActivityWriter::class.java)
//            startActivity(intent)
//        }
//
//        binding.ivHome.setOnClickListener {
//            val intent = Intent(this, WriterActivity::class.java)
//            startActivity(intent)
//        }
    }
}
