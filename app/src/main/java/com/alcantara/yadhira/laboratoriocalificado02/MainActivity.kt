package com.alcantara.yadhira.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnEjercicio01: Button
    private lateinit var btnEjercicio02: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnEjercicio01 = findViewById(R.id.btnEjercicio01)
        btnEjercicio02 = findViewById(R.id.btnEjercicio02)

        btnEjercicio01.setOnClickListener {
            val intent = Intent(this, Ejercicio01::class.java)
            startActivity(intent)
        }

        btnEjercicio02.setOnClickListener {
            val intent = Intent(this, Ejercicio02::class.java)
            startActivity(intent)
        }
    }
}
