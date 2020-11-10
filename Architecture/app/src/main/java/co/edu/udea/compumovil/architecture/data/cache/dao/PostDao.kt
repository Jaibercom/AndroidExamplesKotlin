package co.edu.udea.compumovil.architecture.data.cache.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.edu.udea.compumovil.architecture.data.cache.entity.PostEntity

@Dao
interface PostDao {

    @Query("SELECT * from post_table ORDER BY id ASC")
    fun getPost(): LiveData<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: PostEntity)

    @Query("DELETE FROM post_table")
    suspend fun deleteAll()
}
