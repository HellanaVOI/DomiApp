package be.technifuture.domiapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
class Extension (
    @PrimaryKey(autoGenerate = true)
    val extId: Long = 0,
    val name: String? = null,
    val icon: String? = null,
    var isBlackList: Boolean = false
)

data class ExtWithCard(
    @Embedded val ext: Extension,
    @Relation(
        parentColumn = "extId",
        entityColumn = "cardId"
    )
    val cards: List<Card>
)
