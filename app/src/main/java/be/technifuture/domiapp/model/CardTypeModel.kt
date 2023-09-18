package be.technifuture.domiapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

@Entity(primaryKeys = ["cardId", "typeID"])
data class CardTypeModel(
        var cardId: Long,
        var typeId: Long
)

data class CardWithType(
        @Embedded
        val card: CardModel,
        @Relation(
                parentColumn = "cardId",
                entityColumn = "typeId",
                associateBy = Junction(CardModel::class)
        )
        val genres: List<TypeModel>
)

data class TypeWithCard(
        @Embedded
        val type: TypeModel,
        @Relation(
                parentColumn = "cardId",
                entityColumn = "typeId",
                associateBy = Junction(TypeModel::class)
        )
        val books: List<CardModel>
)