package be.technifuture.domiapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Carte(val name: String, val cout: String, val ext: Extension, val type: List<CardType>): Parcelable

enum class CardType {
    VICTOIRE,
    TRESOR,
    ACTION,
    DUREE,
    REACTION,
}