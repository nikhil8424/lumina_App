package com.example.lumina.admin

import com.google.firebase.database.FirebaseDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lumina.ExamSchedule
import com.example.lumina.R

class AddExam : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_exam)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val subject = findViewById<EditText>(R.id.exam_subject)
        val date = findViewById<EditText>(R.id.exam_date)
        val time = findViewById<EditText>(R.id.exam_time)
        val submitButton = findViewById<Button>(R.id.submitButton)

        // Get the database instance
        val database = FirebaseDatabase.getInstance()

        submitButton.setOnClickListener {
            val subjectText = subject.text.toString()
            val dateText = date.text.toString()
            val timeText = time.text.toString()

            if (subjectText.isEmpty() || dateText.isEmpty() || timeText.isEmpty()) {
                Toast.makeText(this, "Please enter valid values", Toast.LENGTH_SHORT).show()
            } else {
                val newExam = ExamSchedule(subject = subjectText, date = dateText, time = timeText)
                val newExamRef = database.reference.child("Exams").push()
                newExamRef.setValue(newExam).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Exam added successfully", Toast.LENGTH_SHORT).show()
                        subject.setText("")
                        date.setText("")
                        time.setText("")
                    } else {
                        Toast.makeText(this, "Failed to add exam", Toast.LENGTH_SHORT).show()
                        subject.setText("")
                        date.setText("")
                        time.setText("")
                    }
                }
            }
        }
    }
}
