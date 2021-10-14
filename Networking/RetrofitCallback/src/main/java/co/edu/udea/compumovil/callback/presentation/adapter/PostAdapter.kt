package co.edu.udea.compumovil.callback.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.udea.compumovil.callback.R
import co.edu.udea.compumovil.callback.model.Post
import com.google.android.material.snackbar.Snackbar

/**
 * Post Adapter class
 */
class PostAdapter(
    private val clickListener: OnItemClickListener
) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private var deletedPostPosition: Int = 0
    private lateinit var deletedPost: Post
    private var postList = mutableListOf<Post>()

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = postList[position]
        holder.dot.visibility = View.VISIBLE
        holder.contentView.text = post.title
    }

    override fun getItemCount() = postList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dot: TextView = view.findViewById(R.id.blue_dot)
        val contentView: TextView = view.findViewById(R.id.content)

        init {
            view.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }
    }

    fun updatePostList(posts: List<Post>?) {
        this.postList.clear()
        posts?.let { this.postList.addAll(it) }
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int, view: View) {
        deletedPost = postList[position]
        deletedPostPosition = position
        this.postList.removeAt(position)
        notifyItemRemoved(position)
        showUndoSnackbar(view)
    }

    private fun showUndoSnackbar(view: View) {
        val recoverPostSnackbar = Snackbar.make(
            view, R.string.snack_bar_text,
            Snackbar.LENGTH_LONG
        )
        recoverPostSnackbar.apply {
            setAction(R.string.snack_bar_undo) { undoDelete() }
            show()
        }
    }

    private fun undoDelete() {
        postList.add(deletedPostPosition, deletedPost)
        notifyItemInserted(deletedPostPosition)
    }
}
