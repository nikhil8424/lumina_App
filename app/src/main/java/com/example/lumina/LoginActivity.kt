package com.example.lumina

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lumina.admin.AdminActivity
import com.example.lumina.vi.VIActivity
import com.example.lumina.writer.WriterActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var adminRadioButton: RadioButton
    private lateinit var writerRadioButton: RadioButton
    private lateinit var studentRadioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.editTextText2)
        passwordEditText = findViewById(R.id.editTextText)
        submitButton = findViewById(R.id.button)

        adminRadioButton = findViewById(R.id.radioButton4)
        writerRadioButton = findViewById(R.id.radioButton5)
        studentRadioButton = findViewById(R.id.radioButton6)

        val auth = Firebase.auth


        submitButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                Toast.makeText(this@LoginActivity, "Please enter both username and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!adminRadioButton.isChecked && !writerRadioButton.isChecked && !studentRadioButton.isChecked) {
                Toast.makeText(this@LoginActivity, "Please select a role", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = when {
                adminRadioButton.isChecked -> Intent(this@LoginActivity, AdminActivity::class.java)
                writerRadioButton.isChecked -> Intent(this@LoginActivity, WriterActivity::class.java)
                studentRadioButton.isChecked -> Intent(this@LoginActivity, VIActivity::class.java)
                else -> null
            }

            intent?.let {
                startActivity(it)
                finish()
            }
        }
    }
}
