package be.technifuture.domiapp.jsonService

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
    data class ExtensionModel(

        @SerializedName("id")
        var id: String? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("icon")
        var icon: String? = null,
        @SerializedName("isBlackList")
        var isBlackList: Boolean,
        var isSelected: Boolean = false
    ) : Parcelable

data class ExtensionResponse(
        @SerializedName("data")
        var list: MutableList<ExtensionModel>
    )