package com.example.ejericicio11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class Raza : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raza)

        var imagen = findViewById<ImageView>(R.id.imageView)
        var elfo = findViewById<Button>(R.id.belfo)
        var humano = findViewById<Button>(R.id.bhumano)
        var enano = findViewById<Button>(R.id.benano)
        var goblin = findViewById<Button>(R.id.bgoblin)
        var aceptar = findViewById<Button>(R.id.aceptar)

        var raza = ""
        var cambio : Intent

        elfo.setOnClickListener(){
            imagen.setImageResource(R.drawable.elfo)
            raza="elfo"
        }

        humano.setOnClickListener(){
            imagen.setImageResource(R.drawable.humano)
            raza="humano"
        }

        enano.setOnClickListener(){
            imagen.setImageResource(R.drawable.enano)
            raza="enano"
        }

        goblin.setOnClickListener(){
            imagen.setImageResource(R.drawable.goblin)
            raza="goblin"
        }

        aceptar.setOnClickListener(){
            if (raza.equals(""))
                Toast.makeText(this, "Primero selecciona una raza", Toast.LENGTH_SHORT).show()
            else{
                personaje1.setRaza(raza)
            cambio = Intent(this, PantallaInformativa::class.java)
            startActivity(cambio)
            }
        }

    }
}
