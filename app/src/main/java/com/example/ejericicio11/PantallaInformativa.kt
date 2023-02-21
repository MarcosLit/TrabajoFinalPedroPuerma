package com.example.ejericicio11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class PantallaInformativa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_informativa)

        var imagenClase=findViewById<ImageView>(R.id.imagenClase)
        when(personaje1.clase){
            "mago" -> imagenClase.setImageResource(R.drawable.mago)
            "ladron" -> imagenClase.setImageResource(R.drawable.ladron)
            "guerrero" -> imagenClase.setImageResource(R.drawable.guerrero)
            "berserker" -> imagenClase.setImageResource(R.drawable.berserker)
        }

        var imagenRaza=findViewById<ImageView>(R.id.imagenRaza)
        when(personaje1.raza){
            "elfo" -> imagenRaza.setImageResource(R.drawable.elfo)
            "humano" -> imagenRaza.setImageResource(R.drawable.humano)
            "enano" -> imagenRaza.setImageResource(R.drawable.enano)
            "goblin" -> imagenRaza.setImageResource(R.drawable.goblin)
        }

        var fuerza = findViewById<TextView>(R.id.fuerzaInt)
        var numeros = 10..15
        var defensa = findViewById<TextView>(R.id.defensaInt)
        fuerza.text = numeros.random().toString()
        numeros = 1..5
        defensa.text = numeros.random().toString()

        var volver = findViewById<Button>(R.id.volver)
        volver.setOnClickListener(){
            var intent= Intent(this, clase::class.java)
            startActivity(intent)
        }

        var nombre = findViewById<EditText>(R.id.introducenombre)
        var nombrePer : String
        var continuar = findViewById<Button>(R.id.continuar)
        continuar.setOnClickListener(){
            if (nombre.length()==0)
                Toast.makeText(this, "Primero selecciona un nombre", Toast.LENGTH_SHORT).show()
            else{
                nombrePer=nombre.text.toString()
                personaje1.setNombre(nombrePer)
                personaje1.setFuerza(fuerza.text.toString())
                personaje1.setDefensa(defensa.text.toString())
                var intent= Intent(this, InicioAventura::class.java)
                startActivity(intent)
            }
        }

    }
}