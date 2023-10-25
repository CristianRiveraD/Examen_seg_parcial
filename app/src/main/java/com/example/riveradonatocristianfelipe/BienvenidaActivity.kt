package com.example.riveradonatocristianfelipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class BienvenidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val textViewUser = findViewById<TextView>(R.id.textViewUser)
        val buttonSalir = findViewById<Button>(R.id.buttonSalir)

        val apellidos = intent.getStringExtra("apellidos")
        val nombres = intent.getStringExtra("nombres")

        // Verificar si los valores recibidos son nulos antes de mostrarlos
        if (apellidos != null && nombres != null) {
            val nombreCompleto = "$apellidos $nombres"
            textViewUser.text = "Nombre: $nombreCompleto"
        } else {
            textViewUser.text = "Datos de usuario no encontrados"
        }

        buttonSalir.setOnClickListener {
            // Regresar a la pantalla de inicio de sesión
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

