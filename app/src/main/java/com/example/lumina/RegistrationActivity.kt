package com.example.lumina

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.writer_register)

        // Initialize views
        nameEditText = findViewById(R.id.name)
        phoneEditText = findViewById(R.id.Number)
        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        submitButton = findViewById(R.id.button)
        loginButton = findViewById(R.id.loginButton) // The newly added button

        submitButton.setOnClickListener {
            registerUser()
        }

        loginButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java)) // Redirect to LoginActivity
        }
    }

    private fun registerUser() {
        val name = nameEditText.text.toString()
        val phone = phoneEditText.text.toString()
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (name.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        if (!phone.matches("\\d{10}".toRegex())) {
            Toast.makeText(this, "Please enter a valid 10-digit phone number", Toast.LENGTH_SHORT).show()
            return
        }

        // Add Firebase or other registration logic here
    }
}
