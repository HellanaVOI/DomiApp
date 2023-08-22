package be.technifuture.domiapp.jsonService

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
    var type: List<String>? = null,
    @SerializedName("isBlackList")
    var isBlackList: Boolean,
    var isSelected: Boolean = false
)

data class CarResponse(
    @SerializedName("data")
    var list: MutableList<CardModel>
) {
}