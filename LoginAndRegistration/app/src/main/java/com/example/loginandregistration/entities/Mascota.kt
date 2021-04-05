package com.example.loginandregistration.entities

import android.os.Parcel
import android.os.Parcelable

class Mascota (nombre: String): Parcelable {
    var nombre : String

    init {
        this.nombre = nombre
     }

    constructor(source: Parcel) : this(
        source.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) = with(parcel) {
        writeString(nombre)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User = User(source)
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }
}