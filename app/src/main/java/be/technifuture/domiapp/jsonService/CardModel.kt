package be.technifuture.domiapp.jsonService

import be.technifuture.domiapp.CardType
import com.google.gson.annotations.SerializedName

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
    private var type: List<String>? = null,
    @SerializedName("isBlackList")
    var isBlackList: Boolean,
    var isSelected: Boolean = false
){
    fun cardType(): CardType{
        return when(type?.get(0)){
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

data class CarResponse(
    @SerializedName("data")
    var list: MutableList<CardModel>
)

