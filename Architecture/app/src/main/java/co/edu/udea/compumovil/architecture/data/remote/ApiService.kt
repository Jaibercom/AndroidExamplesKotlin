package co.edu.udea.compumovil.architecture.data.remote

import co.edu.udea.compumovil.architecture.data.remote.model.PostResponse
import co.edu.udea.compumovil.architecture.data.remote.model.CommentResponse
import co.edu.udea.compumovil.architecture.data.remote.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *
 * @author jaiber.yepes
 */
interface ApiService {

    @GET("posts")
    suspend fun requestPosts(): List<PostResponse>

    @GET("/users/{id}")
    suspend fun requestUser(@Path(value = "id") userId: Int): UserResponse

    @GET("/comments")
    suspend fun requestComments(@Query(value = "postId") userId: Int): List<CommentResponse>
}
