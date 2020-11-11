package co.edu.udea.compumovil.architecture.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.*
import co.edu.udea.compumovil.architecture.data.cache.PostDatabase
import co.edu.udea.compumovil.architecture.data.remote.RetrofitFactory
import co.edu.udea.compumovil.architecture.presentation.model.PostUI
import co.edu.udea.compumovil.architecture.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *
 * @author jaiber.yepes
 */
class PostViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: DataRepository

//    private var postList = MutableLiveData<List<PostUI>>()
//    lateinit var postsLiveData: LiveData<List<PostUI>>//postList
    var postsLiveData: LiveData<List<PostUI>> = MutableLiveData()

    // Other way
//    var postListLiveData: LiveData<List<PostUI>> = liveData {
//        emit(repository.getAllPost2())
//    }

    init {
        val dao = PostDatabase.getDatabase(application, viewModelScope).postDao()
        val apiService = RetrofitFactory.apiService()
        repository = DataRepository(dao, apiService, viewModelScope)
        postsLiveData = repository.getAllPost()
    }

    fun requestPosts() {
        // Coroutine that will be canceled when the ViewModel is cleared.
        viewModelScope.launch {
            requestRemotePosts()
        }
    }

    private fun requestRemotePosts() {
//        return withContext(Dispatchers.IO) {
//            repository.requestRemotePost()
//        }
        return repository.requestRemotePost()
    }

    /**
     * Launching a new coroutine to delete the data in a non-blocking way
     */
    fun deletePosts() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }
}
