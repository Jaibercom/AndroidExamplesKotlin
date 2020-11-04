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
    var postsLiveData: LiveData<List<Post>> = posts

    // Other way
//    var postListLiveData: LiveData<List<Post>> = liveData {
//        emit(requestPosts())
//    }

    init {
        getPosts()
    }

    fun getPosts() {
        // Coroutine that will be canceled when the ViewModel is cleared.
        viewModelScope.launch {
            posts.value = requestPosts()
        }
    }

    private suspend fun requestPosts(): List<Post> {
        return withContext(Dispatchers.IO) {
            apiService.requestPosts()
        }
    }

    fun deletePosts() {
        posts.value = emptyList()
    }
}
