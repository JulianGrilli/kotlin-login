package com.example.loginandregistration.service

import com.example.loginandregistration.entities.Mascota
import com.example.loginandregistration.repository.MascotaRepository

class MascotaService {

    var mascotaRepository: MascotaRepository = MascotaRepository()

    fun findAll(): MutableList<Mascota>{
        return mascotaRepository.findAll()
    }

    fun findByPosition(position: Int): Mascota {
        return mascotaRepository.findPosition(position)
    }
}