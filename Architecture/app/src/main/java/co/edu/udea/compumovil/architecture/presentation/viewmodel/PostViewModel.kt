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
    var allPosts: LiveData<List<PostUI>> = MutableLiveData()

    init {
        val dao = PostDatabase.getDatabase(application, viewModelScope).postDao()
        val apiService = RetrofitFactory.apiService()
        repository = DataRepository(dao, apiService)
        allPosts = repository.allPosts
//        requestPosts()
    }

    fun requestPosts() {
        // Coroutine that will be canceled when the ViewModel is cleared.
        viewModelScope.launch {
            requestRemotePosts()
        }
    }

    private suspend fun requestRemotePosts() {
        return withContext(Dispatchers.IO) {
            repository.refreshPost()
        }
    }

    /**
     * Launching a new coroutine to delete the data in a non-blocking way
     */
    fun deletePosts() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }
}
