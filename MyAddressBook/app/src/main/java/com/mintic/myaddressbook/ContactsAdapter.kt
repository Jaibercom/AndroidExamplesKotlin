package com.mintic.myaddressbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


class ContactsAdapter(
    private val mContacts: ArrayList<Contact>
) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder, position: Int
    ) {
        val (firstName, lastName, email) = mContacts[position]
        val fullName = "$firstName $lastName"
        holder.nameLabel.text = fullName
        holder.emailLabel.text = email
    }

    override fun getItemCount(): Int {
        return mContacts.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameLabel: TextView = itemView.findViewById(R.id.textview_name)
        var emailLabel: TextView = itemView.findViewById(R.id.textview_email)

        init {
//            itemView.setOnClickListener { showAddContactDialog(adapterPosition) }

        }
    }
}
