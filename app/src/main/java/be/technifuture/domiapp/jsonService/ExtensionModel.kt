package be.technifuture.domiapp.jsonService

import be.technifuture.domiapp.Extension
import com.google.gson.annotations.SerializedName


    data class ExtensionModel(

        @SerializedName("id")
        var id: String? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("icon")
        var icon: String? = null,
        @SerializedName("isBlackList")
        var isBlackList: String? = null,
    )

    data class ExtensionResponse(
        @SerializedName("data")
        var listCrypto: MutableList<ExtensionModel>
    )