package com.example.ejericicio11

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class InicioAventura : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_aventura)

        var dado = findViewById<ImageButton>(R.id.dado)
        var cambio = Intent(this, InicioAventura::class.java)


        dado.setOnClickListener(){
            val numeros = 1..4
            val numero = numeros.random().toString()
            when(numero){
                "1"->cambio= Intent(this, Ciudad::class.java)
                "2"->cambio= Intent(this, Enemigo::class.java)
                "3"->cambio= Intent(this, Mercader::class.java)
                "4"->cambio= Intent(this, Objeto::class.java)
            }
            startActivity(cambio)
        }

    }
}