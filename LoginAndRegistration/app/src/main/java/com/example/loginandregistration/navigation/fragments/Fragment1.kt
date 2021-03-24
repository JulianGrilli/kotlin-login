package com.example.loginandregistration.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.loginandregistration.R
import com.example.loginandregistration.entities.User
import com.example.loginandregistration.service.UserService
import com.google.android.material.snackbar.Snackbar

class Fragment1 : Fragment() {

    lateinit var v: View
    lateinit var btnLogin: Button
    lateinit var btnRegistrar: Button
    lateinit var userName: EditText
    lateinit var passWord: EditText
    var userService: UserService = UserService()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_1, container, false)
        btnLogin = v.findViewById(R.id.button)
        userName = v.findViewById(R.id.userName)
        passWord = v.findViewById(R.id.passWord)
        return v
    }

    override fun onStart() {
        super.onStart()
        btnLogin.setOnClickListener {
            val user = User(userName.text.toString(), passWord.text.toString())
            val existe = verificarSiElUsuarioExiste(user)
            if (existe){
                //Redireccionar a siguiente fragment
                redirectToAction2(user)
            } else {
                Snackbar.make(v,"Credenciales Incorrectas", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun verificarSiElUsuarioExiste(user: User): Boolean {
        val existe = userService.findUserByUsernameAndPassword(user.email, user.password)
        return existe
    }

    private fun redirectToAction2(user: User){
        // Preguntar como sabe que es el 2
        val action2 = Fragment1Directions.actionFragment1ToFragment2(user)
        v.findNavController().navigate(action2)
    }

}