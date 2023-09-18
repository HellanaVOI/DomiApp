package be.technifuture.domiapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.google.gson.annotations.SerializedName

@Entity
data class CardModel(
    @PrimaryKey(autoGenerate = true)
    var cardId: Long = 0,
    var name: String? = null,
    var cout: String? = null,
    @SerializedName("is_black_list")
    var isBlackList: Boolean = false
)

data class CardAndExtension(
    @Embedded val card: CardModel,
    @Relation(
        parentColumn = "cardId",
        entityColumn = "extId"
    )
    val ext: ExtensionModel )