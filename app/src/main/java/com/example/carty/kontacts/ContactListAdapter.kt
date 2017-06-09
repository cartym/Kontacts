package com.example.carty.kontacts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

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
        vh.label.text = localContacts[position].name
        return view
    }

    private class ListRowHolder(row: View?) {
        var localRow = row
        public val label = localRow?.findViewById(R.id.nameTextView) as TextView

    }
}