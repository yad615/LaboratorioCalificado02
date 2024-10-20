package com.alcantara.yadhira.laboratoriocalificado02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.alcantara.yadhira.laboratoriocalificado02.R

class Ejercicio01 : AppCompatActivity() {
    private lateinit var btnMostrar: Button
    private lateinit var btnOcultar: Button
    private lateinit var viewVerde: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio01)

        btnMostrar = findViewById(R.id.btnMostrar)
        btnOcultar = findViewById(R.id.btnOcultar)
        viewVerde = findViewById(R.id.viewVerde)

        btnMostrar.setOnClickListener {
            viewVerde.visibility = View.VISIBLE
        }

        btnOcultar.setOnClickListener {
            viewVerde.visibility = View.GONE
        }
    }
}