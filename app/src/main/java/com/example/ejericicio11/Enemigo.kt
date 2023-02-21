package com.example.ejericicio11

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class Enemigo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enemigo)

        var numeros=1..6
        var numerosJefe = 1..2

        var cambio : Intent
        var frase = findViewById<TextView>(R.id.vidaPerosnaje_texto)
        var luchar = findViewById<Button>(R.id.luchar)
        var huir = findViewById<Button>(R.id.huir)
        var decisionEnemigo = findViewById<LinearLayout>(R.id.decisionEnemigo)
        var accionesLucha = findViewById<LinearLayout>(R.id.accionesLucha)
        var vidaEnemigo = findViewById<ProgressBar>(R.id.vidaEnemigo)
        var vidaPersonaje = findViewById<ProgressBar>(R.id.vidaPersonaje)
        var fotoEnemigo = findViewById<ImageView>(R.id.fotoEnemigo)
        var atacar = findViewById<Button>(R.id.atacar)
        var objeto = findViewById<Button>(R.id.objeto)

        var villano : VillanoClase

        //Boton Luchar
        luchar.setOnClickListener(){
            accionesLucha.visibility = (View.VISIBLE)
            decisionEnemigo.visibility = (View.INVISIBLE)
        }


        //Boton Huir
        huir.setOnClickListener(){
            var numero = numeros.random()
            if (numero>=5){
                Toast.makeText(this, "Escapaste sin problemas", Toast.LENGTH_LONG).show()
                cambio = Intent(this, InicioAventura::class.java)
                startActivity(cambio)
            }else{
                Toast.makeText(this, "No pudiste escapar", Toast.LENGTH_LONG).show()
                accionesLucha.visibility = (View.VISIBLE)
                decisionEnemigo.visibility = (View.INVISIBLE)
            }
        }

        //Frase de codigo para establecer el nombre en la frase de la vida del personaje
        frase.text = resources.getString(R.string.vida_personaje, personaje1.nombre)



        //Establecer valores de la barra de vida del enemigo
        var enemigoTipo = numerosJefe.random()
        if (enemigoTipo==1){ //si es 1 sera jefe normal
            fotoEnemigo.setImageResource(R.drawable.enemigo)
            vidaEnemigo.max = 100
            vidaEnemigo.progress = villanoNormal.vida
            villano = villanoNormal
        }else{
            fotoEnemigo.setImageResource(R.drawable.enemigojefe)
            vidaEnemigo.max = 200
            vidaEnemigo.progress = villanoJefe.vida
            villano = villanoJefe
        }


        //Establecer barra de vida del Personaje
        vidaPersonaje.max= 200
        vidaPersonaje.progress = personaje1.vida


        //Funcion atacar
        atacar.setOnClickListener(){
            var ataqueEfectivo = numeros.random()
            if(ataqueEfectivo>=4) {
                //Personaje ataca
                Toast.makeText(this, "¡PUM!", Toast.LENGTH_SHORT).show()
                villano.vida = villano.vida - personaje1.fuerza.toInt()
                vidaEnemigo.progress = villano.vida
                println(villano.vida)

                //Comprobar si al enemigo le queda vida
                if (villano.vida<=0){
                    Toast.makeText(this, "El enemigo ha muerto", Toast.LENGTH_SHORT).show()
                    villanoNormal.vida=100
                    villanoJefe.vida=200
                    Thread.sleep(2000)
                    cambio = Intent(this, InicioAventura::class.java)
                    startActivity(cambio)
                }

            }else
                Toast.makeText(this, "Ataque fallado", Toast.LENGTH_SHORT).show()

            ataqueEnemigo(villano)
        }







    }

    fun ataqueEnemigo(villano : VillanoClase){
        var vidaPersonaje = findViewById<ProgressBar>(R.id.vidaPersonaje)
        var cambio2 : Intent

        personaje1.vida = personaje1.vida - villano.ataque / personaje1.fuerza.toInt()
        vidaPersonaje.progress = personaje1.vida

        if (personaje1.vida<=0){
            cambio2 =Intent(this, Muerte::class.java)
            startActivity(cambio2)
        }
    }
}