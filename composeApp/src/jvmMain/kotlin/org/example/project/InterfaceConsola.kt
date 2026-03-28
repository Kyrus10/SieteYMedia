package org.example.project

import org.example.project.recursos.Carta
import kotlin.collections.forEach

class InterfaceConsola {

    private val juego = SieteYMedia()

    init {
        presentarJuego()
        jugar()
    }

    fun jugar(){
        turnoJugador()
        turnoBanca()
        println("Adios")
    }

    fun presentarJuego() {
        println("- El usuario es el jugador y el ordenador la banca.")
        println("- No hay en la baraja 8s y 9s. El 10 es la sota, el 11 el caballo y el 12 el Rey.")
        println("- Las figuras valen medio punto y el resto su valor.")
        println("- Primero juega el jugador.")
        println("- El jugador puede pedir cartas o plantarse.")
        println("- Si supera 7.5 pierde.")
        println("- Luego juega la banca, que debe empatar o superar al jugador sin pasarse.")
        println("\nEmpecemos!!!\n")
    }

    fun turnoJugador() {
        var opc = 'C'

        println("Como mínimo recibes una carta")

        while (juego.valorJugador() < 7.5 && opc == 'C') {

        juego.pedirCarta()

            println("Éstas son tus cartas jugador:")
            mostrarCartas(juego.getCartasJugador())

            val valor = juego.valorJugador()
            println("\n\tValor de cartas: $valor")

            if (valor < 7.5) {
                println("\n¿Pides [C]arta o te [P]lantas?")
                opc = readln().trim().uppercase()[0]

                if (opc == 'C') {
                    juego.pedirCarta()
                }
            }
        }
    }

    fun turnoBanca() {

        val valorJugador = juego.valorJugador()

        if (valorJugador > 7.5) {
            println("Jugador, te has pasado, gana la banca")
            return
        }

        println("\norg.example.project.Turno de banca ...")

        while (juego.valorBanca() < juego.valorJugador()) {
            juego.pedirCartaBanca()
        }

        println("Éstas son mis cartas:")
        mostrarCartas(juego.getCartasBanca())

        val valor = juego.valorBanca()
        println("\nValor de mis cartas: $valor")

        if (valor > 7.5)
            println("Me pasé, ganas tú jugador")
        else
            println("Gana la banca")
    }

    fun mostrarCartas(cartas: List<Carta>) {
        cartas.forEach { print("\t$it") }
        println()
    }
}