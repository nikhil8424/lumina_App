package com.example.lumina.admin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lumina.R
import com.google.firebase.database.FirebaseDatabase

class QueriesAdmin : ComponentActivity() {

    private lateinit var home: ImageView
    private lateinit var profile: ImageView
    private lateinit var submit: Button
    private lateinit var queryField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addqueries_admin)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.query_admin)) { view, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val database = FirebaseDatabase.getInstance()

        home = findViewById(R.id.ivHome)
        profile = findViewById(R.id.ivProfile)
        submit = findViewById(R.id.button2)
        queryField = findViewById(R.id.query_text)

        home.setOnClickListener {
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
        }

        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivityAdmin::class.java)
            startActivity(intent)
        }

        submit.setOnClickListener{
            val body = queryField.text.toString()

            if(queryField.text.isEmpty()){
                Toast.makeText(this, "Please enter valid values", Toast.LENGTH_SHORT).show()
            }
            else{
                val newQueryRef = database.reference.child("Queries").push()
                newQueryRef.setValue(body).addOnCompleteListener{task->
                    if(task.isSuccessful){
                        Toast.makeText(this, "Query sent successfully", Toast.LENGTH_SHORT).show()
                        queryField.setText("")
                    }
                    else{
                        Toast.makeText(this, "Query could not be sent", Toast.LENGTH_SHORT).show()
                        queryField.setText("")
                    }
                }
            }
        }
    }
}
