package be.technifuture.domiapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Carte(val name: String, val cout: String, val ext: Extension, val type: List<CardType>): Parcelable{

    override fun toString(): String {
        return "Carte(name='$name', cout='$cout', ext='$ext')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Carte

        if (name != other.name) return false
        if (ext != other.ext) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + ext.hashCode()
        return result
    }


}