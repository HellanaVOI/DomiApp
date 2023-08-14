package be.technifuture.domiapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Extension (
    val id :Int,
    val name :String,
    val icon :Int,
    var isBlackList: Boolean,
    var isSelected: Boolean = false,
    ) :Parcelable