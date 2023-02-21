package com.example.ejericicio11

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Mercader : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mercader)

        var cambio : Intent

        var continuar = findViewById<Button>(R.id.continuarComercio)
        var comerciar = findViewById<Button>(R.id.comerciar)
        var linearOpcion = findViewById<LinearLayout>(R.id.linearOpcion)
        var linearComercio = findViewById<LinearLayout>(R.id.linearComercio)
        var cancelarComercio = findViewById<Button>(R.id.cancelarComercio)
        var imagenMercader = findViewById<ImageView>(R.id.imagenMercader)
        var layoutComprar = findViewById<LinearLayout>(R.id.layoutComprar)
        var layoutVenta = findViewById<LinearLayout>(R.id.layoutVenta)
        var comprar = findViewById<Button>(R.id.comprar)
        var vender = findViewById<Button>(R.id.vender)
        var compraMas  = findViewById<Button>(R.id.compraMas)
        var compraMenos = findViewById<Button>(R.id.compraMenos)
        var vendeMas = findViewById<Button>(R.id.vendeMas)
        var vendeMenos = findViewById<Button>(R.id.vendeMenos)
        var compraCantidad = findViewById<TextView>(R.id.compraCantidad)
        var vendeCantidad = findViewById<TextView>(R.id.vendeCantidad)

        comerciar.setOnClickListener(){
            linearOpcion.visibility = (View.INVISIBLE)
            linearComercio.visibility = (View.VISIBLE)
        }

        cancelarComercio.setOnClickListener(){
            imagenMercader.setImageResource(R.drawable.mercader)
            linearComercio.visibility = (View.INVISIBLE)
            linearOpcion.visibility = (View.VISIBLE)
            layoutVenta.visibility = (View.INVISIBLE)
            layoutComprar.visibility = (View.INVISIBLE)
        }

        comprar.setOnClickListener(){
            imagenMercader.setImageResource(R.drawable.obj)
            layoutComprar.visibility = (View.VISIBLE)
            layoutVenta.visibility = (View.INVISIBLE)
        }

        vender.setOnClickListener(){
            imagenMercader.setImageResource(R.drawable.mochila)
            layoutComprar.visibility = (View.INVISIBLE)
            layoutVenta.visibility = (View.VISIBLE)
        }

        compraMas.setOnClickListener(){
            compraCantidad.text = (compraCantidad.text.toString().toInt()+1).toString()
        }
        compraMenos.setOnClickListener(){
            if (compraCantidad.text.toString().toInt()>0)
                compraCantidad.text = (compraCantidad.text.toString().toInt()-1).toString()
        }


        vendeMas.setOnClickListener(){
            if (vendeCantidad.text.toString().toInt()+1 <= personaje1.mochila.interior.size)
                vendeCantidad.text = (vendeCantidad.text.toString().toInt()+1).toString()
            else
                Toast.makeText(this, "No tienes esa cantidad de objetos en la mochila", Toast.LENGTH_LONG).show()
        }

        vendeMenos.setOnClickListener(){
            if (vendeCantidad.text.toString().toInt()>0){
                vendeCantidad.text = (vendeCantidad.text.toString().toInt()-1).toString()
            }
        }


        continuar.setOnClickListener(){
            cambio = Intent(this, InicioAventura::class.java)
            startActivity(cambio)
        }
    }
}