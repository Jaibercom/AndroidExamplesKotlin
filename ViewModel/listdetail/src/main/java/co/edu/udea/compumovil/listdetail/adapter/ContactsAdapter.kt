package co.edu.udea.compumovil.listdetail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.udea.compumovil.listdetail.R
import co.edu.udea.compumovil.listdetail.model.Contact


class ContactsAdapter(
    private val onClick: (Contact) -> Unit
) : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    private var mContacts = mutableListOf<Contact>()

    fun setContactList(mContacts: MutableList<Contact>) {
        this.mContacts = mContacts
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holderContact: ContactViewHolder, position: Int) {
        val contact = mContacts[position]
        holderContact.bind(contact = contact)
    }

    override fun getItemCount(): Int {
        return mContacts.size
    }

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nameLabel: TextView = itemView.findViewById(R.id.textview_name)
        private var emailLabel: TextView = itemView.findViewById(R.id.textview_email)

        private var currentContact: Contact? = null

        init {
            itemView.setOnClickListener {
                currentContact?.let {
                    onClick(it)
                }
            }
        }

        /* Bind Contact name and image. */
        fun bind(contact: Contact) {
            currentContact = contact

            val fullName = "${contact.firstName} ${contact.lastName}"
            nameLabel.text = fullName
            emailLabel.text = contact.email
        }
    }
}
