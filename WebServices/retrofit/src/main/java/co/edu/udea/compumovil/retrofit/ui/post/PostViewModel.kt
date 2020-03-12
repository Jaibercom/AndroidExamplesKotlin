package co.edu.udea.compumovil.retrofit.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.edu.udea.compumovil.retrofit.api.RetrofitFactory
import co.edu.udea.compumovil.retrofit.model.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostViewModel : ViewModel() {

    private var apiService = RetrofitFactory.apiService()

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _posts = MutableLiveData<List<Post>>()
    var posts: LiveData<List<Post>> = _posts

    init {
        initializePosts()
    }

    fun initializePosts() {
        uiScope.launch {
            _posts.value = requestPosts()
        }
    }

    private suspend fun requestPosts(): List<Post>? {
        return withContext(Dispatchers.IO) {
            apiService.requestPosts()
        }
    }

    fun deletePosts() {
        _posts.value = emptyList()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
