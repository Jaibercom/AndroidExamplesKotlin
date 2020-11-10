package co.edu.udea.compumovil.architecture.data

import co.edu.udea.compumovil.architecture.data.cache.entity.PostEntity
import co.edu.udea.compumovil.architecture.presentation.model.PostUI
import co.edu.udea.compumovil.architecture.util.BaseMapper

/**
 * Auth Mapper for mapping between data & presentation layers.
 *
 * @author jaiber.yepes
 */
object PostDataMapper {

    object PostListCacheToUI : BaseMapper<List<PostEntity>, List<PostUI>> {

        override fun map(type: List<PostEntity>): List<PostUI> {
            return type.map {
                PostUI(
                    title = it.title,
                    body = it.body
                )
            }
        }
    }


}
