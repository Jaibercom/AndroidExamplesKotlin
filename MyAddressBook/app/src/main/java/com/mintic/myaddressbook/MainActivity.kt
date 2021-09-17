package com.mintic.myaddressbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var mContacts: ArrayList<Contact>
    private lateinit var mAdapter: ContactsAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.contact_list)

        mContacts = createMockContacts()
        mAdapter = ContactsAdapter(mContacts)
        setupRecyclerView()
    }

    /**
     * Sets up the RecyclerView: empty data set, item dividers, swipe to delete.
     */
    private fun setupRecyclerView() {
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        recycler.adapter = mAdapter
    }

    private fun createMockContacts(): ArrayList<Contact> {
        return arrayListOf(
            Contact("Jose", "Perez", "jose@gmail.com"),
            Contact("Jose", "Perez", "jose@gmail.com"),
            Contact("Jose", "Perez", "jose@gmail.com"),
            Contact("Juan", "Perez", "juan@gmail.com")
        )
    }
}