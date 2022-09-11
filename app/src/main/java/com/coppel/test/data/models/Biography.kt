package com.example.example

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Biography : Parcelable {
    @SerializedName("full-name")
    var fullName: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("alter-egos")
    var alterEgos: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("aliases")
    var aliases: ArrayList<String> = arrayListOf()

    @SerializedName("place-of-birth")
    var placeOfBirth: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("first-appearance")
    var firstAppearance: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("publisher")
    var publisher: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("alignment")
    var alignment: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field
}