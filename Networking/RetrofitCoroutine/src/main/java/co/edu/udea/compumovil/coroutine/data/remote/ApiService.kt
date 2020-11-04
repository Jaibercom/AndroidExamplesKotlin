package co.edu.udea.compumovil.coroutine.data.remote

import co.edu.udea.compumovil.coroutine.model.Comment
import co.edu.udea.compumovil.coroutine.model.Post
import co.edu.udea.compumovil.coroutine.model.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("posts")
    suspend fun requestPosts(): List<Post>

    @GET("/users/{id}")
    suspend fun requestUser(@Path(value = "id") userId: Int): User

    @GET("/comments")
    suspend fun requestComments(@Query(value = "postId") userId: Int): List<Comment>
}
