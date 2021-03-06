package com.example.loginandregistration.repository

import android.content.res.Resources
import com.example.loginandregistration.entities.User
import java.util.*

object UserRepository {

    var listaUsuarios: MutableList<User> = mutableListOf(
        User("flor@gmail.com", "passwordflor", "Flor", "Garduno"),
        User("juli@gmail.com", "passwordjuli", "Julian", "Grilli"),
        User("fede@gmail.com", "passwordfede", "Federico", "Mateucci"),
        User("mati@gmail.com", "passwordmati", "Matias", "Romera"))

    fun findByUsernameAndPassword(username: String, password: String): User {
        val usuarioFiltrado = listaUsuarios.filter { userRepo ->
            userRepo.email.equals(username) && userRepo.password.equals(password)
        }
        return getResultFromFilter(usuarioFiltrado)
    }

    fun save(user: User){
        listaUsuarios.add(user)
    }

    fun getResultFromFilter(usuarioFiltrado : List<User>): User{
        if ( usuarioFiltrado.size > 0) {
            return usuarioFiltrado.get(0)
        } else {
            throw Resources.NotFoundException("User no encontrado")
        }
    }
}