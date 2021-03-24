package com.example.loginandregistration.service

import com.example.loginandregistration.repository.UserRepository

class UserService {

    var userRepository: UserRepository = UserRepository()

    fun findUserByUsernameAndPassword(email: String, password: String): Boolean{
        val usuarioFiltrado = userRepository.findByUsernameAndPassword(email, password)
        return usuarioFiltrado.size >  0
    }
}