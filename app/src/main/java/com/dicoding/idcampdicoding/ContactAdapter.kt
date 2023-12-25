package com.dicoding.idcampdicoding

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val context: Context, private val contactList: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textContactName)
        val phoneTextView: TextView = itemView.findViewById(R.id.textContactPhone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contactList[position]
        holder.nameTextView.text = currentContact.name
        holder.phoneTextView.text = currentContact.phoneNumber

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ContactDetailActivity::class.java).apply {
                putExtra(ContactDetailActivity.EXTRA_CONTACT_NAME, currentContact.name)
                putExtra(ContactDetailActivity.EXTRA_CONTACT_PHONE, currentContact.phoneNumber)
                putExtra(ContactDetailActivity.EXTRA_CONTACT_PROFILE_PICTURE, currentContact.profilePicture)
                putExtra(ContactDetailActivity.EXTRA_CONTACT_DESCRIPTION, currentContact.description)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}

