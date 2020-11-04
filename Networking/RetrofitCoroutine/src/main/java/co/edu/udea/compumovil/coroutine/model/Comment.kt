package co.edu.udea.compumovil.coroutine.model

import com.google.gson.annotations.SerializedName

data class Comment(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("body")
    val body: String

)
