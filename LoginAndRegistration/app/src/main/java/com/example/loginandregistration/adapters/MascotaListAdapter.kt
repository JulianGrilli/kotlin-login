package com.example.loginandregistration.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.loginandregistration.R
import com.example.loginandregistration.entities.Mascota

class MascotaListAdapter (

    private var mascotas: MutableList<Mascota>,
    val onItemClick: (Int) -> Boolean // Recibe una funcion que recibe un entero y devuelve boolean
    ) : RecyclerView.Adapter<MascotaListAdapter.MascotaHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaHolder {
        // Aca es donde referencio los items hijos del parent
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mascota, parent, false)
        return (MascotaListAdapter.MascotaHolder(view))
    }

    override fun getItemCount(): Int {
        return mascotas.size
    }

    override fun onBindViewHolder(holder: MascotaHolder, position: Int) {
        // Aca mi informacion que seria el nombre de la mascota, impacta en el holder y lo muestro
        holder.setName(mascotas[position].nombre)
        holder.getCardLayout().setOnLongClickListener(){
            onItemClick(position)
        }

    }

    class MascotaHolder(v:View) : RecyclerView.ViewHolder(v) {
        // Contiene acciones y referencias con respecto a la vista
        // Conexion entre adapter y xml del item
        private var view: View

        init {
            this.view = v
        }

        fun setName(name: String){
            val txt: TextView = view.findViewById(R.id.txt_name_item)
            txt.text = name
        }

        fun getCardLayout ():CardView{
            // Me posiciono sobre el click especifico de la card
            return view.findViewById(R.id.card_package_item)
        }

    }

}