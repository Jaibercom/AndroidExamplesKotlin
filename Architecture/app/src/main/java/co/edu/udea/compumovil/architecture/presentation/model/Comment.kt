package co.edu.udea.compumovil.architecture.presentation.model

import com.google.gson.annotations.SerializedName

/**
 *
 * @author jaiber.yepes
 */
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
