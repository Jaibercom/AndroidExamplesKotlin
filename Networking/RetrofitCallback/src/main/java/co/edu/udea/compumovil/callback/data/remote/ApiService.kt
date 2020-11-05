package co.edu.udea.compumovil.callback.data.remote

import co.edu.udea.compumovil.callback.model.Post
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {

    @GET("posts")
    fun requestPosts(): Call<List<Post>>

//    @GET("/users/{id}")
//    suspend fun requestUser(@Path(value = "id") userId: Int): User
//
//    @GET("/comments")
//    suspend fun requestComments(@Query(value = "postId") userId: Int): List<Comment>
}
