package co.edu.udea.compumovil.listdetail.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import co.edu.udea.compumovil.listdetail.model.Contact
import co.edu.udea.compumovil.listdetail.adapter.ContactsAdapter
import co.edu.udea.compumovil.listdetail.R
import java.util.ArrayList
import androidx.lifecycle.ViewModelProvider
import co.edu.udea.compumovil.listdetail.viewmodel.ContactViewModel


/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var mContacts: ArrayList<Contact>
    private lateinit var mAdapter: ContactsAdapter
    private lateinit var recycler: RecyclerView
    private lateinit var model: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = ViewModelProvider(requireActivity()).get(ContactViewModel::class.java)

        recycler = view.findViewById(R.id.contact_list)
        setupRecyclerView()
    }

    /**
     * Sets up the RecyclerView: empty data set, item dividers, swipe to delete.
     */
    private fun setupRecyclerView() {
        mContacts = createMockContacts()
        recycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        mAdapter = ContactsAdapter(mContacts) { contact ->
            contactOnClick(contact)
        }

        recycler.adapter = mAdapter
    }

    /* RecyclerView item is clicked. */
    private fun contactOnClick(contact: Contact) {
        Log.d(TAG, "Click on: $contact")
    }

    private fun createMockContacts(): ArrayList<Contact> {
        return arrayListOf(
            Contact("Jose", "Perez", "jose@gmail.com"),
            Contact("Natalia", "Perez", "nata@gmail.com"),
            Contact("Pepito", "Perez", "pepito@gmail.com"),
            Contact("Juan", "Perez", "juan@gmail.com")
        )
    }

    companion object {
        private val TAG = ListFragment::class.java.simpleName
    }
}
