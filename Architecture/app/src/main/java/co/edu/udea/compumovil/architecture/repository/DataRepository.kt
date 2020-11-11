package co.edu.udea.compumovil.architecture.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import co.edu.udea.compumovil.architecture.data.cache.dao.PostDao
import co.edu.udea.compumovil.architecture.data.cache.entity.PostEntity
import co.edu.udea.compumovil.architecture.data.remote.ApiService
import co.edu.udea.compumovil.architecture.data.remote.model.PostResponse
import co.edu.udea.compumovil.architecture.presentation.model.PostUI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 *
 * @author jaiber.yepes
 */
// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class DataRepository(
    private val postDao: PostDao,
    private val apiService: ApiService,
    private val viewModelScope: CoroutineScope
) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
//    val getPost: List<PostUI> = PostDataMapper.PostListCacheToUI.map(postDao.getPost().value!!)

    private var allPosts = MutableLiveData<List<PostUI>>()
    private var postsEntityLiveData: LiveData<List<PostEntity>> = postDao.getAllPost()

    fun getAllPost(): LiveData<List<PostUI>> = postsEntityLiveData.switchMap { posts ->
        if (posts.isNullOrEmpty()) {
            requestRemotePost()
        }
        allPosts.postValue(postDataMapperCacheToUI(posts))
        allPosts
    }

    suspend fun deleteAll() {
        postDao.deleteAll()
    }

    fun requestRemotePost() {
        viewModelScope.launch(Dispatchers.IO) {
            val postResponse = apiService.requestPosts()
            postDao.insertPosts(postDataMapperRemoteToCache(postResponse))
        }
    }

    private fun postDataMapperCacheToUI(postList: List<PostEntity>): List<PostUI> =
        postList.map { post ->
            PostUI(
                title = post.title,
                body = post.body
            )
        }.toList()

    private fun postDataMapperRemoteToCache(postList: List<PostResponse>): List<PostEntity> =
        postList.map { post ->
            PostEntity(
                id = post.id,
                title = post.title,
                body = post.body
            )
        }.toList()

//    fun getPost(): LiveData<List<PostUI>> = postDao.getPost().map {
//        PostDataMapper.PostListCacheToUI.map(it)
//    }

    suspend fun insert(post: PostEntity) {
        postDao.insert(post)
    }

}
