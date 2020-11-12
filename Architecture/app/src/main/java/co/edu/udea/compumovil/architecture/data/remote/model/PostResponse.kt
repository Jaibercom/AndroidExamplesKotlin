package co.edu.udea.compumovil.architecture.data.remote.model

import co.edu.udea.compumovil.architecture.data.cache.entity.PostEntity
import com.google.gson.annotations.SerializedName

data class PostResponse(

    @SerializedName("userId")
    val userId: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String

)

/**
 * Map Post to data entities
 */
fun List<PostResponse>.asCacheModel(): List<PostEntity> {
    return map {
        PostEntity(
            id = it.id,
            title = it.title,
            body = it.body
        )
    }
}
