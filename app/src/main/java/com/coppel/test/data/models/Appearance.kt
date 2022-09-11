package com.example.example

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Appearance : Parcelable {
    @SerializedName("gender")
    var gender: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("race")
    var race: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("height")
    var height: ArrayList<String> = arrayListOf()

    @SerializedName("weight")
    var weight: ArrayList<String> = arrayListOf()

    @SerializedName("eye-color")
    var eyeColor: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("hair-color")
    var hairColor: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field
}