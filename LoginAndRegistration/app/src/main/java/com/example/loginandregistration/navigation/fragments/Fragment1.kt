package com.example.loginandregistration.navigation.fragments

import android.content.res.Resources
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
        btnLogin = v.findViewById(R.id.btn_login)
        btnRegistrar = v.findViewById(R.id.btn_signin)
        userName = v.findViewById(R.id.userName)
        passWord = v.findViewById(R.id.passWord)
        return v
    }

    override fun onStart() {
        super.onStart()
        btnLogin.setOnClickListener {
            val user = verificarSiElUsuarioExiste(userName.text.toString(), passWord.text.toString())
            if (user != null){
                redirectToAction2(user)
            }
        }
        btnRegistrar.setOnClickListener {
            redirectToAction3()
        }
    }

    private fun verificarSiElUsuarioExiste(email: String, password: String): User? {
        try {
            val user = userService.findUserByUsernameAndPassword(email, password)
            return user
        }catch (e: Resources.NotFoundException) {
            Snackbar.make(v,"Credenciales Incorrectas", Snackbar.LENGTH_SHORT).show()
        }
        return null
    }

    private fun redirectToAction2(user: User){
        val action2 = Fragment1Directions.actionFragment1ToFragment2(user)
        v.findNavController().navigate(action2)
    }

    private fun redirectToAction3(){
        val action3 = Fragment1Directions.actionFragment1ToFragment3()
        v.findNavController().navigate(action3)
    }

}