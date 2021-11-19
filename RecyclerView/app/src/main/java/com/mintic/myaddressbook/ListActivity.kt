package com.mintic.myaddressbook

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException
import java.util.ArrayList
import org.json.JSONArray
import org.json.JSONException

class ListActivity : AppCompatActivity() {

    private lateinit var mContacts: ArrayList<Contact>
    private lateinit var mAdapter: ContactAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.contact_list)
        setupRecyclerView()
        initDataFromFile()
//        mContacts = createMockContacts()
    }

    /**
     * Sets up the RecyclerView: empty data set, item dividers, swipe to delete.
     */
    private fun setupRecyclerView() {
        mContacts = arrayListOf()
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        mAdapter = ContactAdapter(mContacts, this)

        recycler.adapter = mAdapter
    }

    /* RecyclerView item is clicked. */
    private fun contactOnClick(contact: Contact) {
        Log.d(TAG, "Click on: $contact")
    }

    /**
     * Generates mock contact data to populate the UI from a JSON file in the
     * assets directory, called from the options menu.
     */
    private fun initDataFromFile() {
        val contactsString = readContactJsonFile()
        try {
            val contactsJson = JSONArray(contactsString)
            for (i in 0 until contactsJson.length()) {
                val contactJson = contactsJson.getJSONObject(i)
                val contact = Contact(
                    contactJson.getString("first_name"),
                    contactJson.getString("last_name"),
                    contactJson.getString("email"),
                    contactJson.getString("imageUrl")
                )
                Log.d(TAG, "generateContacts: $contact")
                mContacts.add(contact)
            }

            mAdapter.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    /**
     * Reads a file from the assets directory and returns it as a string.
     *
     * @return The resulting string.
     */
    private fun readContactJsonFile(): String? {
        var contactsString: String? = null
        try {
            val inputStream = assets.open("mock_contacts.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            contactsString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return contactsString
    }

    private fun createMockContacts(): ArrayList<Contact> {
        return arrayListOf(
            Contact("Hector", "Cortez", "hectorc@gmail.com", ""),
            Contact("Johana", "Mafla", "johanam@gmail.com", ""),
            Contact("Jose", "Perez", "josep@gmail.com", ""),
            Contact("Juan", "Londoño", "juanl@gmail.com", "")
        )
    }

    companion object {
        private val TAG = ListActivity::class.java.simpleName
    }
}