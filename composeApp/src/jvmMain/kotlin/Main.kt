package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.project.recursos.Turno

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Siete y Media") {
        val presentador = remember { PresentadorSieteYMedia() }
        SieteYMediaApp(presentador)
    }
}

@Composable
fun SieteYMediaApp(presentador: PresentadorSieteYMedia) {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("SIETE Y MEDIA", style = MaterialTheme.typography.h4)

            Spacer(modifier = Modifier.height(16.dp))

            Text("Tus cartas:", style = MaterialTheme.typography.h6)
            Text(presentador.cartasJugador.joinToString("  ") { it.toString() })
            Text("Valor: ${presentador.valorJugador}")

            Spacer(modifier = Modifier.height(16.dp))

            if (presentador.turno != Turno.JUGADOR) {
                Text("Cartas de la banca:", style = MaterialTheme.typography.h6)
                Text(presentador.cartasBanca.joinToString("  ") { it.toString() })
                if (presentador.turno == Turno.PARTIDA_TERMINADA) {
                    Text("Valor: ${presentador.valorBanca}")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (presentador.turno == Turno.JUGADOR) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = { presentador.pedirCarta() }) {
                        Text("Pedir carta")
                    }
                    Button(onClick = { presentador.plantarse() }) {
                        Text("Plantarse")
                    }
                }
            }

            if (presentador.turno == Turno.PARTIDA_TERMINADA) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(presentador.ganador, style = MaterialTheme.typography.h5)
            }
        }
    }
}
