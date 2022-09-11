package com.example.example

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Hero : Parcelable {
    @SerializedName("response")
    var response: String? = null

    @SerializedName("id")
    var id: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("name")
    var name: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("powerstats")
    var powerStats: Powerstats? = Powerstats()

    @SerializedName("biography")
    var biography: Biography? = Biography()

    @SerializedName("appearance")
    var appearance: Appearance? = Appearance()

    @SerializedName("work")
    var work: Work? = Work()

    @SerializedName("connections")
    var connections: Connections? = Connections()

    @SerializedName("image")
    var image: Image? = Image()
}