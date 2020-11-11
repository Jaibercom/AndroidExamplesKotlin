package co.edu.udea.compumovil.architecture.data.cache.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.edu.udea.compumovil.architecture.data.cache.entity.PostEntity

/**
 *
 * @author jaiber.yepes
 */
@Dao
interface PostDao {

    @Query("SELECT * from post_table ORDER BY id ASC")
    fun getAllPost(): LiveData<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(post: PostEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<PostEntity>)

    @Query("DELETE FROM post_table")
    suspend fun deleteAll()

}
