package com.mintic.myaddressbook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.ArrayList


class ContactsAdapter(
    private val mContacts: ArrayList<Contact>,
    private val context: Context,
    private val onClick: (Contact) -> Unit
) : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

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
        private var imageView: ImageView = itemView.findViewById(R.id.imageview_thumb)
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

            Glide.with(context)
                .load(contact.imageUrl)
                .into(imageView)
        }
    }
}
