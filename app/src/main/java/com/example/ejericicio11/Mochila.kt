package com.example.ejericicio11

class Mochila {
    var pesoMochila = 100
    var interior = ArrayList<Articulo>()

    @JvmName("getPesoMochila1")
    fun getPesoMochila():Int{
        return pesoMochila
    }

    @JvmName("setPesoMochila1")
    fun setPesoMochila(nuevoPeso:Int){
        this.pesoMochila=nuevoPeso
    }
}