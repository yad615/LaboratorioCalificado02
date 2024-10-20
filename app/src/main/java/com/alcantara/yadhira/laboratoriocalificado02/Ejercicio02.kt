package com.alcantara.yadhira.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class Ejercicio02 : AppCompatActivity() {
    private lateinit var etNombre: TextInputEditText
    private lateinit var etProductos: TextInputEditText
    private lateinit var etDireccion: TextInputEditText
    private lateinit var etTelefono: TextInputEditText
    private lateinit var btnRegistrar: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio02)

        initializeViews()
        setupListeners()
    }

    private fun initializeViews() {
        etNombre = findViewById(R.id.etNombre)
        etProductos = findViewById(R.id.etProductos)
        etDireccion = findViewById(R.id.etDireccion)
        etTelefono = findViewById(R.id.etTelefono)
        btnRegistrar = findViewById(R.id.btnRegistrar)
    }

    private fun setupListeners() {
        btnRegistrar.setOnClickListener {
            if (validarCampos()) {
                val intent = Intent(this, ResultadoActivity::class.java).apply {
                    putExtra("nombre", etNombre.text.toString())
                    putExtra("productos", etProductos.text.toString())
                    putExtra("direccion", etDireccion.text.toString())
                    putExtra("telefono", etTelefono.text.toString())
                }
                startActivity(intent)
            }
        }
    }

    private fun validarCampos(): Boolean {
        when {
            etNombre.text.toString().isEmpty() -> {
                etNombre.error = "Ingrese el nombre"
                etNombre.requestFocus()
                return false
            }
            etProductos.text.toString().isEmpty() -> {
                etProductos.error = "Ingrese los productos"
                etProductos.requestFocus()
                return false
            }
            etDireccion.text.toString().isEmpty() -> {
                etDireccion.error = "Ingrese la dirección"
                etDireccion.requestFocus()
                return false
            }
            etTelefono.text.toString().isEmpty() -> {
                etTelefono.error = "Ingrese el teléfono"
                etTelefono.requestFocus()
                return false
            }
        }
        return true
    }
}
