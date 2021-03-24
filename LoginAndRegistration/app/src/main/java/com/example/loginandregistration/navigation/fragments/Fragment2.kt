package com.example.loginandregistration.navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.loginandregistration.R
import com.example.loginandregistration.entities.User
import com.google.android.material.snackbar.Snackbar

class Fragment2 : Fragment() {

    lateinit var v: View
    lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v=  inflater.inflate(R.layout.fragment_2, container, false)
        return v
    }

    override fun onStart() {
        super.onStart()
        user = Fragment2Args.fromBundle(requireArguments()).user
        var message = "bienvenido: " + user.email + " !"
        Snackbar.make(v,message,Snackbar.LENGTH_SHORT).show()
    }
}