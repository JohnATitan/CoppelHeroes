package com.example.example

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Connections : Parcelable {
    @SerializedName("group-affiliation")
    var groupAffiliation: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("relatives")
    var relatives: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field
}