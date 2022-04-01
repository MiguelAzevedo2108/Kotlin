package com.example.bobi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_process()

    }

    private fun login_process() {
        findViewById<Button>(R.id.btn_login).setOnClickListener {
            if (validateCredentials()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun validateCredentials(): Boolean {
        val username = findViewById<EditText>(R.id.fill_username).text.toString()
        val password = findViewById<EditText>(R.id.fill_password).text.toString()

        if (username.isEmpty() or password.isEmpty()) {
            findViewById<TextView>(R.id.wrong_credentials).visibility = View.VISIBLE
            return false
        }

        return username == password
    }

}