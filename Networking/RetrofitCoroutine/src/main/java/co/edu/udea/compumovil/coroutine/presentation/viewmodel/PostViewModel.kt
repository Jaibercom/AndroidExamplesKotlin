package co.edu.udea.compumovil.coroutine.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.udea.compumovil.coroutine.data.remote.RetrofitFactory
import co.edu.udea.compumovil.coroutine.model.Post
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    private var apiService = RetrofitFactory.apiService()
    private var posts = MutableLiveData<List<Post>>()

    init {
        requestPosts()
    }

    fun getPosts(): LiveData<List<Post>> = posts

    fun requestPosts() {
        // Coroutine that will be canceled when the ViewModel is cleared.
        viewModelScope.launch {
            posts.value = apiService.requestPosts()
        }
    }

    fun deletePosts() {
        posts.value = emptyList()
    }
}
