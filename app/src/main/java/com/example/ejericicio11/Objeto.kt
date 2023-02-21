package com.example.ejericicio11

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Objeto : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)

        var cambio : Intent

        var recoger = findViewById<Button>(R.id.recoger)
        var continuarRecoger = findViewById<Button>(R.id.continuarRecoger)

        recoger.setOnClickListener(){
            if ((personaje1.mochila.getPesoMochila() - articulo.getPeso()) >= 0){
                personaje1.mochila.setPesoMochila(personaje1.mochila.getPesoMochila() - articulo.getPeso())
                personaje1.mochila.interior.add(articulo)
                println("Objeto introducido")
                println("Peso de la mochila cambiado")
                println(personaje1.mochila.getPesoMochila().toString())
                println(personaje1.mochila.interior.size.toString())
            }else{
                Toast.makeText(this, "La mochila esta llena, por favor contacta con el mercader", Toast.LENGTH_LONG).show()
            }
        }

        continuarRecoger.setOnClickListener(){
            cambio = Intent(this, InicioAventura::class.java)
            startActivity(cambio)
        }

    }
}