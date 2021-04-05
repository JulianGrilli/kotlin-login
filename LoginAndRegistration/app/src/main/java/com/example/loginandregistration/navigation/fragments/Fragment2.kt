package com.example.loginandregistration.navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginandregistration.R
import com.example.loginandregistration.adapters.MascotaListAdapter
import com.example.loginandregistration.entities.Mascota
import com.example.loginandregistration.entities.User
import com.example.loginandregistration.repository.MascotaRepository
import com.example.loginandregistration.service.MascotaService
import com.google.android.material.snackbar.Snackbar

class Fragment2 : Fragment() {

    lateinit var v: View
    lateinit var user: User
    lateinit var recMascotas: RecyclerView
    var mascotas : MutableList<Mascota> = ArrayList<Mascota>()
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var mascotasListAdapter: MascotaListAdapter
    var mascotaService: MascotaService = MascotaService()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v=  inflater.inflate(R.layout.fragment_2, container, false)
        recMascotas = v.findViewById(R.id.recMascotas)
        return v
    }

    override fun onStart() {
        super.onStart()
        user = Fragment2Args.fromBundle(requireArguments()).user
        var message = "Bienvenido: " + user.name + " " + user.lastName + " !"
        Snackbar.make(v,message,Snackbar.LENGTH_SHORT).show()
        mascotas = mascotaService.findAll()

        // Layout configuration
        recMascotas.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recMascotas.layoutManager = linearLayoutManager

        // La funcion que le paso es lo que hara en cada click para cada posicion
        // Aca podriamnos ir a buscar byId o algo asi
        mascotasListAdapter = MascotaListAdapter(mascotas) {x -> onItemClick(x)}
        recMascotas.adapter = mascotasListAdapter
    }

    fun onItemClick (position: Int): Boolean {
        val mascota = mascotaService.findByPosition(position)
        Snackbar.make(v, mascota.nombre.toString(), Snackbar.LENGTH_SHORT).show()
        return true;
    }
}