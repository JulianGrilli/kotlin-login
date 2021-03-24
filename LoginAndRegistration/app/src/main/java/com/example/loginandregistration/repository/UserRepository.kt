package com.example.loginandregistration.repository

import com.example.loginandregistration.entities.User
import java.util.*

class UserRepository {

    var listaUsuarios: List<User> = Arrays.asList(
        User("flor@gmail.com", "passwordflor"),
        User("juli@gmail.com", "passwordjuli"),
        User("fede@gmail.com", "passwordfede"),
        User("mati@gmail.com", "passwordmati"))

    fun findByUsernameAndPassword(username: String, password: String): List<User> {
        val usuarioFiltrado = listaUsuarios.filter { userRepo ->
            userRepo.email.equals(username) && userRepo.password.equals(password)
        }
        return usuarioFiltrado
    }
}