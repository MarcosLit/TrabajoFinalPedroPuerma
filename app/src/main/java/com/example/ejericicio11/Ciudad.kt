package com.example.ejericicio11

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Ciudad : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudad)

        var cambio:Intent
        var entrar = findViewById<Button>(R.id.entrar)
        var continar = findViewById<Button>(R.id.continuarCiudad)

        entrar.setOnClickListener(){
            Toast.makeText(this, "Entrar", Toast.LENGTH_SHORT).show()
        }

        continar.setOnClickListener(){
            cambio = Intent(this, InicioAventura::class.java)
            startActivity(cambio)
        }
    }
}