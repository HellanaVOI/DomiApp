package be.technifuture.domiapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/*@Entity
data class ExtensionModel(
    @PrimaryKey(autoGenerate = true)
    var extId: Long = 0,
    var name: String? = null,
    var icon: String? = null,
    @SerializedName("is_black_list")
    var isBlackList: Boolean = false,
)*/

data class ExtensionModel(

    var id: String,
    var name: ExtensionName,
    var icon: String,
)

data class ExtensionName(
    var fr: String,
    var en: String
)

data class ExtensionResponse(
    @SerializedName("data")
    var list: MutableList<ExtensionModel>
)