package com.example.carty.kontacts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

/**
 * Created by caitlinmartins on 2017-06-08.
 */

open class ContactListAdapter(contacts: Array<Contact>, context: Context): BaseAdapter() {
    var localContacts = contacts;

    override fun getCount(): Int {
        return localContacts.size
    }

    override fun getItem(position: Int): Any {
        return localContacts[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    private val mInflater = LayoutInflater.from(context)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val vh: ListRowHolder

        if(convertView == null){
            view = mInflater?.inflate(R.layout.contact_row, parent, false)
            vh = ListRowHolder(view)
            view?.tag = vh

        }else{
            view = convertView
            vh = view.tag as ListRowHolder

        }

        val currentContact = localContacts[position]
        vh.nameLabel.text = currentContact.name
        vh.phoneNumberLabel.text = currentContact.phoneNumber[0].toString()

        return view
    }

    private class ListRowHolder(row: View?) {
        val nameLabel: TextView = row?.findViewById(R.id.nameTextView) as TextView
        val phoneNumberLabel: TextView = row?.findViewById(R.id.numberTextView) as TextView
        val contactImage: ImageView = row?.findViewById(R.id.contactImageView) as ImageView
    }
}