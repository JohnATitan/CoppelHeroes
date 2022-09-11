package com.example.example

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize

class Work : Parcelable {
    @SerializedName("occupation")
    var occupation: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field

    @SerializedName("base")
    var base: String? = null
        get() = if (field.equals("null") || field?.length == 0) null else field
}