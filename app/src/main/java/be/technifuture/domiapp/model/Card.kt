package be.technifuture.domiapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class Card(
    @PrimaryKey(autoGenerate = true)
    val cardId: Long = 0,
    val name: String? = null,
    val cout: String? = null,
    var isBlackList: Boolean = false
)