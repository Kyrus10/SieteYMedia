package org.example.project

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.example.project.recursos.Turno

class PresentadorSieteYMedia {
    private val juego = SieteYMedia()

    var turno by mutableStateOf(Turno.JUGADOR)
    var ganador by mutableStateOf("")
    var cartasJugador by mutableStateOf(juego.getCartasJugador().toList())
    var cartasBanca by mutableStateOf(juego.getCartasBanca().toList())
    var valorJugador by mutableStateOf(0.0)
    var valorBanca by mutableStateOf(0.0)

    fun pedirCarta() {
        if (turno != Turno.JUGADOR) return
        juego.pedirCarta()
        cartasJugador = juego.getCartasJugador().toList()
        valorJugador = juego.valorJugador()
        if (juego.valorJugador() > 7.5) {
            ganador = "Te has pasado, gana la banca"
            turno = Turno.PARTIDA_TERMINADA
        }
    }

    fun plantarse() {
        if (turno != Turno.JUGADOR) return
        turno = Turno.BANCA
        while (juego.valorBanca() < juego.valorJugador()) {
            juego.pedirCartaBanca()
        }
        cartasBanca = juego.getCartasBanca().toList()
        valorBanca = juego.valorBanca()
        ganador = if (juego.valorBanca() > 7.5) "La banca se pasó, ¡ganas tú!" else "Gana la banca"
        turno = Turno.PARTIDA_TERMINADA
    }
}