package co.edu.udea.compumovil.architecture.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.*
import co.edu.udea.compumovil.architecture.data.cache.PostDatabase
import co.edu.udea.compumovil.architecture.presentation.model.PostUI
import co.edu.udea.compumovil.architecture.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: DataRepository
//    private var apiService = RetrofitFactory.apiService()

//    private var postList = MutableLiveData<List<PostUI>>()
    var postsLiveData: LiveData<List<PostUI>>

    // Other way
//    var postListLiveData: LiveData<List<Post>> = liveData {
//        emit(requestPosts())
//    }

    init {
        val dao = PostDatabase.getDatabase(application, viewModelScope).postDao()
        repository = DataRepository(dao)
        postsLiveData = repository.getPost()
    }

//    init {
//        getPosts()
//    }

//    fun getPosts() {
//        // Coroutine that will be canceled when the ViewModel is cleared.
//        viewModelScope.launch {
//            postList.value = requestPosts()
//        }
//    }
//
//    private suspend fun requestPosts(): List<PostUI> {
//        return withContext(Dispatchers.IO) {
//            apiService.requestPosts()
//        }
//    }
//
//    fun deletePosts() {
//        postList.value = emptyList()
//    }
}
