package co.edu.udea.compumovil.architecture.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import co.edu.udea.compumovil.architecture.R
import co.edu.udea.compumovil.architecture.presentation.adapter.PostAdapter
import co.edu.udea.compumovil.architecture.presentation.viewmodel.PostViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

/**
 *
 * @author jaiber.yepes
 */
class PostFragment : Fragment(), PostAdapter.OnItemClickListener {

    private lateinit var viewModel: PostViewModel
    private lateinit var postAdapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_post, container, false)
        val postList = view.findViewById<RecyclerView>(R.id.post_list)
        val deleteFab = view.findViewById<FloatingActionButton>(R.id.delete_fab)

        setHasOptionsMenu(true)

        setupRecyclerView(postList)
        deleteFab.setOnClickListener(onDeleteClick())
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PostViewModel::class.java)

        viewModel.allPosts.observe(viewLifecycleOwner, Observer {
            postAdapter.updatePostList(it)
        })
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        postAdapter = PostAdapter(this as PostAdapter.OnItemClickListener)
        recyclerView.adapter = postAdapter

        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(postAdapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    override fun onItemClick(position: Int) {
        Log.d("PostFragment", "onItemClick $position")
    }

    private fun onDeleteClick() = View.OnClickListener { view ->
        Snackbar.make(view, "Delete?", Snackbar.LENGTH_LONG)
            .setAction("OK", oKListener()).show()
    }

    private fun oKListener() = View.OnClickListener {
        Log.d("PostFragment", "Deleting")
        viewModel.deletePosts()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_post_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_refresh -> {
                Log.d("PostFragment", "Action refresh")
                viewModel.requestPosts()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        fun newInstance() = PostFragment()
    }
}
