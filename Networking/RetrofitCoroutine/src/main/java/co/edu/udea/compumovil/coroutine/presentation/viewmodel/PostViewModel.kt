package co.edu.udea.compumovil.coroutine.presentation.viewmodel

import androidx.lifecycle.*
import co.edu.udea.compumovil.coroutine.data.remote.RetrofitFactory
import co.edu.udea.compumovil.coroutine.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
            posts.value = requestSuspendPosts()
        }
    }

    private suspend fun requestSuspendPosts(): List<Post> {
        return withContext(Dispatchers.IO) {
            apiService.requestPosts()
        }
    }

    fun deletePosts() {
        posts.value = emptyList()
    }
}
