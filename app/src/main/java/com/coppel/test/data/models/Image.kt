package com.example.example

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Image : Parcelable {
    @SerializedName("url")
    var url: String? = null
}