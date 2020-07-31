package noflow.logged.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IBMREquest(
    @SerializedName("fields") val fields: List<String>,
    @SerializedName("values") val values: List<List<String>>
) : Parcelable