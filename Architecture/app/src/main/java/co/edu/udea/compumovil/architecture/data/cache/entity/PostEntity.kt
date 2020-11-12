package co.edu.udea.compumovil.architecture.data.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import co.edu.udea.compumovil.architecture.presentation.model.PostUI

/**
 *
 * @author jaiber.yepes
 */
@Entity(tableName = "post_table")
data class PostEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "body")
    val body: String

)

/**
 * Map Post to domain entities
 */
fun List<PostEntity>.asDomainModel(): List<PostUI> {
    return map {
        PostUI(
            title = it.title,
            body = it.body
        )
    }
}
