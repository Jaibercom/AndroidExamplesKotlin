package co.edu.udea.compumovil.architecture.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import co.edu.udea.compumovil.architecture.data.cache.dao.PostDao
import co.edu.udea.compumovil.architecture.data.cache.entity.PostEntity
import co.edu.udea.compumovil.architecture.data.cache.entity.asDomainModel
import co.edu.udea.compumovil.architecture.data.remote.ApiService
import co.edu.udea.compumovil.architecture.data.remote.model.PostResponse
import co.edu.udea.compumovil.architecture.presentation.model.PostUI

/**
 *
 * @author jaiber.yepes
 */
// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class DataRepository(
    private val postDao: PostDao,
    private val apiService: ApiService
) {
    // Room executes all queries on a separate thread.
    var allPosts: LiveData<List<PostUI>> = postDao.getAllPost().map {
        it.asDomainModel()
    }

    suspend fun deleteAll() {
        postDao.deleteAll()
    }

    suspend fun refreshPost() {
        val postResponse = apiService.requestPosts()
        postDao.insertPosts(postDataMapperRemoteToCache(postResponse))
    }

    private fun postDataMapperRemoteToCache(postList: List<PostResponse>): List<PostEntity> =
        postList.map { post ->
            PostEntity(
                id = post.id,
                title = post.title,
                body = post.body
            )
        }.toList()

    suspend fun insert(post: PostEntity) {
        postDao.insert(post)
    }
}
