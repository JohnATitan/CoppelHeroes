package com.example.example

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Powerstats : Parcelable {
    @SerializedName("intelligence")
    var intelligence: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("strength")
    var strength: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("speed")
    var speed: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("durability")
    var durability: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("power")
    var power: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("combat")
    var combat: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field
}