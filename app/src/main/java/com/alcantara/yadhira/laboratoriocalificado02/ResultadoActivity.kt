package com.alcantara.yadhira.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class ResultadoActivity : AppCompatActivity() {
    private lateinit var tvNombre: TextView
    private lateinit var tvProductos: TextView
    private lateinit var tvDireccion: TextView
    private lateinit var tvTelefono: TextView
    private lateinit var btnLlamar: MaterialButton
    private lateinit var btnWhatsapp: MaterialButton
    private lateinit var btnMaps: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        initializeViews()
        populateData()
        setupListeners()
    }

    private fun initializeViews() {
        tvNombre = findViewById(R.id.tvNombre)
        tvProductos = findViewById(R.id.tvProductos)
        tvDireccion = findViewById(R.id.tvDireccion)
        tvTelefono = findViewById(R.id.tvTelefono)
        btnLlamar = findViewById(R.id.btnLlamar)
        btnWhatsapp = findViewById(R.id.btnWhatsapp)
        btnMaps = findViewById(R.id.btnMaps)
    }

    private fun populateData() {
        intent.extras?.let { extras ->
            tvNombre.text = "Nombre: ${extras.getString("nombre", "")}"
            tvProductos.text = "Productos: ${extras.getString("productos", "")}"
            tvDireccion.text = "Dirección: ${extras.getString("direccion", "")}"
            tvTelefono.text = "Teléfono: ${extras.getString("telefono", "")}"
        }
    }

    private fun setupListeners() {
        btnLlamar.setOnClickListener {
            val telefono = tvTelefono.text.toString().split(":")[1].trim()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$telefono"))
            startActivity(intent)
        }

        btnWhatsapp.setOnClickListener {
            val nombre = tvNombre.text.toString().split(":")[1].trim()
            val productos = tvProductos.text.toString().split(":")[1].trim()
            val direccion = tvDireccion.text.toString().split(":")[1].trim()
            val mensaje = "Hola $nombre, Tus productos: $productos están en camino a la dirección: $direccion"
            val url = "https://wa.me/?text=${Uri.encode(mensaje)}"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        btnMaps.setOnClickListener {
            val direccion = tvDireccion.text.toString().split(":")[1].trim()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$direccion"))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }
    }
}
