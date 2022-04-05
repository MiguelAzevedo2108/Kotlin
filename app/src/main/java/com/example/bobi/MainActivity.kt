package com.example.bobi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

private const val FIFI = "https://github.com/android-training-program/aula-5/blob/master/images/fifi.jpg?raw=true"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openDetailsActivity()
    }

    private fun openDetailsActivity(){
        val intent = Intent(this,ListActivity::class.java)
        startActivity(intent)
    }
}