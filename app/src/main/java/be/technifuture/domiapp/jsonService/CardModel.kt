package be.technifuture.domiapp.jsonService

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardModel(

    @SerializedName("id")
    var id: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("cout")
    var cout: String? = null,
    @SerializedName("ext")
    var extension: String? = null,
    @SerializedName("type")
    var type: List<String>? = null,
    @SerializedName("isBlackList")
    var isBlackList: Boolean,
    var isSelected: Boolean = false
) : Parcelable {
    fun cardType(id: Int): CardType{
        return when(type?.get(id)){
            "ACTION" ->
                CardType.ACTION
            "REACT" ->
                CardType.REACTION
            "TREASOR" ->
                CardType.TRESOR
            "TIME" ->
                CardType.DUREE
            else ->
                CardType.ACTION
        }
    }
}

enum class CardType {
    VICTOIRE,
    TRESOR,
    ACTION,
    DUREE,
    REACTION
}

data class CarResponse(
    @SerializedName("data")
    var list: MutableList<CardModel>
)

