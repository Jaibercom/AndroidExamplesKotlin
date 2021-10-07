package co.edu.udea.compumovil.callback.data.remote

import co.edu.udea.compumovil.callback.model.Comment
import co.edu.udea.compumovil.callback.model.Post
import co.edu.udea.compumovil.callback.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("posts")
    fun requestPosts(): Call<List<Post>>

    @GET("/users/{id}")
    fun requestUser(@Path(value = "id") userId: Int): Call<User>

    @GET("/comments")
    fun requestComments(@Query(value = "postId") userId: Int): Call<List<Comment>>
}
