package com.example.house_of_cuisines.Model


import com.google.gson.annotations.SerializedName

data class BaseResponseBean(
    @SerializedName("error")
    val error: Boolean, // false
    @SerializedName("msg")
    val msg: String
) {

}