package com.example.riveradonatocristianfelipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Datos de usuario fijos
    private val miUser = "Rivera Donato Cristian Felipe"
    private val miContra = "12345"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            } else if (username == miUser && password == miContra) {
                // Dividir el nombre en Apellido y Nombres
                val parts = username.split(" ")
                if (parts.size >= 2) {
                    val apellidos = parts[0] + " " + parts[1]
                    val nombres = parts.subList(2, parts.size).joinToString(" ")

                    // Navegar a la pantalla de bienvenida y enviar datos
                    val intent = Intent(this, BienvenidaActivity::class.java)
                    intent.putExtra("apellidos", apellidos)
                    intent.putExtra("nombres", nombres)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Nombre de usuario no válido", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
