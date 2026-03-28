package org.example.project

import org.example.project.recursos.Baraja
import org.example.project.recursos.Carta

class SieteYMedia {

    private val cartasJugador = mutableListOf<Carta>()
    private val cartasBanca = mutableListOf<Carta>()
    private val baraja = Baraja()

    init {
        baraja.barajar()
    }

    fun pedirCarta() {
        cartasJugador.add(baraja.darCartas(1).first())
    }

    fun pedirCartaBanca() {
        cartasBanca.add(baraja.darCartas(1).first())
    }

    fun valorJugador(): Double {
        return valorCartas(cartasJugador)
    }

    fun valorBanca(): Double {
        return valorCartas(cartasBanca)
    }

    fun valorCartas(cartas: List<Carta>): Double =
        cartas.sumOf {
            if (it.numero > 7) 0.5 else it.numero.toDouble()
        }


    fun getCartasJugador(): List<Carta> = cartasJugador
    fun getCartasBanca(): List<Carta> = cartasBanca
}