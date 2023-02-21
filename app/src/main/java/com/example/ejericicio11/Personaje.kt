package com.example.ejericicio11

import android.widget.TextView


class Personaje {
    var nombre : String = ""
    var clase : String = ""
    var raza : String = ""
    var fuerza : String = ""
    var defensa : String = ""
    var mochila : Mochila = Mochila()
    var vida : Int = 200
    var monedero : Map<Int, Int> = mapOf()

    constructor(nombre : String, clase : String, raza : String ,fuerza : String, defensa : String, mochila: Mochila, vida : Int, monedero : Map<Int, Int>){
        this.nombre=nombre
        this.clase=clase
        this.raza=raza
        this.fuerza=fuerza
        this.defensa=defensa
        this.mochila=mochila
        this.vida=vida
        this.monedero=monedero
    }

    @JvmName("getClase1")
    fun getClase(): String{
        return clase
    }
    @JvmName("getRaza1")
    fun getRaza(): String{
        return raza
    }

    @JvmName("setRaza1")
    fun setRaza(nRaza: String){
        raza=nRaza
    }

    @JvmName("setClase1")
    fun setClase(nClase:String){
        clase=nClase
    }

    @JvmName("setNombre1")
    fun setNombre(nClase:String){
        nombre=nClase
    }

    @JvmName("setFuerza1")
    fun setFuerza(nClase: String){
        fuerza=nClase
    }

    @JvmName("setDefensa1")
    fun setDefensa(nClase:String){
        defensa=nClase
    }

}