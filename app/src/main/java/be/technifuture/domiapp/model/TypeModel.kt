package be.technifuture.domiapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class TypeModel(
    @PrimaryKey(autoGenerate = true)
    var typeId: Long = 0,
    var name: String? = null
)