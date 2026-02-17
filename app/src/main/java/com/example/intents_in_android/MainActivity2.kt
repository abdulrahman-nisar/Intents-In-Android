package com.example.intents_in_android

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age", 0)
        val textViewName = findViewById<TextView>(R.id.name)
        val textViewAge = findViewById<TextView>(R.id.age)
        val backButton = findViewById<TextView>(R.id.back_button)
        textViewName.text = name
        textViewAge.text = age.toString()

        backButton.setOnClickListener {
            finish()
        }
    }
}