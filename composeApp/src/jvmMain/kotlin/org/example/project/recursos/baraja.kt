package org.example.project.recursos

class Baraja {
    val mazo = mutableListOf<Carta>()

    init {
        for (p in Palo.values()) {
            for (n in 1..12) {
                if (n != 8 && n != 9) {
                    mazo.add(Carta(p, n))
                }
            }
        }
    }

    fun barajar() =  mazo.shuffle()

    //aunque con siete y media solo se pide 1 carta, escribimos la función
    // para cualquier número de cartas por si cambiamos de juego
    fun darCartas(numCartas: Int): List<Carta> {
        if (numCartas > mazo.size) return emptyList()

        val cartas = mazo.take(numCartas) //lista de cartas pedidas
        repeat(numCartas) { mazo.removeAt(0) } //actualizar el mazo

        return cartas
    }
}