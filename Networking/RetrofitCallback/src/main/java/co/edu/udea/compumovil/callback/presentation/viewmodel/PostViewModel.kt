package co.edu.udea.compumovil.callback.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.edu.udea.compumovil.callback.data.remote.RetrofitFactory
import co.edu.udea.compumovil.callback.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostViewModel : ViewModel() {

    private var apiService = RetrofitFactory.apiService()
    private var posts = MutableLiveData<List<Post>>()
    private var isFailure = MutableLiveData(false)

    fun getPosts(): LiveData<List<Post>> = posts
    fun getIsFailure(): LiveData<Boolean> = isFailure

    init {
        requestPosts()
    }

    fun requestPosts() {
        val call = apiService.requestPosts()
        call.enqueue(object : Callback<List<Post>?> {
            override fun onResponse(call: Call<List<Post>?>, response: Response<List<Post>?>) {
                posts.value = response.body()
            }

            override fun onFailure(call: Call<List<Post>?>, t: Throwable) {
                // todo deal with the failed network request
                isFailure.value = true
            }
        })
    }

    fun deletePosts() {
        posts.value = emptyList()
    }
}
