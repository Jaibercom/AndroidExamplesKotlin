package co.edu.udea.compumovil.architecture.repository

import androidx.arch.core.util.Function
import androidx.lifecycle.*
import co.edu.udea.compumovil.architecture.data.PostDataMapper
import co.edu.udea.compumovil.architecture.data.cache.dao.PostDao
import co.edu.udea.compumovil.architecture.data.cache.entity.PostEntity
import co.edu.udea.compumovil.architecture.presentation.model.PostUI
import co.edu.udea.compumovil.architecture.presentation.model.User


// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class DataRepository(private val postDao: PostDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
//    val getPost: List<PostUI> = PostDataMapper.PostListCacheToUI.map(postDao.getPost().value!!)

    fun getUsersLiveData(): LiveData<List<PostUI>> {
        val postsLiveData: LiveData<List<PostEntity>> = postDao.getPost()

        return postsLiveData.map { postList ->
            postList.map { post -> PostUI(post.title, post.body) }.toList()
        }
    }

    fun getPost(): LiveData<List<PostUI>> = postDao.getPost().map {
        PostDataMapper.PostListCacheToUI.map(it)
    }

    suspend fun insert(post: PostEntity) {
        postDao.insert(post)
    }

}