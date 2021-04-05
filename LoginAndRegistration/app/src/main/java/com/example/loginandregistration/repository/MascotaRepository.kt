package com.example.loginandregistration.repository

import com.example.loginandregistration.entities.Mascota
import java.text.FieldPosition

class MascotaRepository {

    var mascotas : MutableList<Mascota> = mutableListOf(
            Mascota("Alfredo"),
            Mascota("Tomi"),
            Mascota("Tobi"),
            Mascota("Can"),
            Mascota("Rupert"),
            Mascota("Margarita"),
            Mascota("Tincho"),
            Mascota("Zira"))

    fun findAll(): MutableList<Mascota> {
        return mascotas
    }

    fun findPosition(position: Int): Mascota {
        return mascotas.get(position)
    }
}