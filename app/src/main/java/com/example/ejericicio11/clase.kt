package com.example.ejericicio11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class clase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clase)

        var imagen = findViewById<ImageView>(R.id.imageView)
        var comenzar = findViewById<Button>(R.id.button)
        var mago = findViewById<Button>(R.id.mago)
        var ladron = findViewById<Button>(R.id.ladron)
        var guerrero = findViewById<Button>(R.id.gurrero)
        var berserker = findViewById<Button>(R.id.berserker)

        var clase = ""
        var cambio : Intent

        mago.setOnClickListener(){
            imagen.setImageResource(R.drawable.mago)
            clase="mago"
        }

        ladron.setOnClickListener(){
            imagen.setImageResource(R.drawable.ladron)
            clase="ladron"
        }

        guerrero.setOnClickListener(){
            imagen.setImageResource(R.drawable.guerrero)
            clase="guerrero"
        }

        berserker.setOnClickListener(){
            imagen.setImageResource(R.drawable.berserker)
            clase="berserker"
        }

        comenzar.setOnClickListener(){
            if (clase.equals("")){
                Toast.makeText(this, "Primero selecciona una clase", Toast.LENGTH_SHORT).show()
            }else{
                personaje1.setClase(clase)
                cambio= Intent(this, Raza::class.java)
                startActivity(cambio)
            }
        }

    }
}