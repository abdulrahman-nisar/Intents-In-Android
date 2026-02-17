package com.example.intents_in_android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val implicitIntent = findViewById<Button>(R.id.implicit_intent)
        val explicitIntentBundle = findViewById<Button>(R.id.explicit_intent_bundle)
        val explicitIntentExtras = findViewById<Button>(R.id.explicit_intent_extras)

        implicitIntent.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, "https://www.google.com".toUri())
            startActivity(intent)
        }

        explicitIntentBundle.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            val bundle = Bundle()
            bundle.putString("name", "Abdulrahman")
            bundle.putInt("age", 21)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        explicitIntentExtras.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name", "Abdulrahman")
            intent.putExtra("age", 21)
            startActivity(intent)
        }
    }
}