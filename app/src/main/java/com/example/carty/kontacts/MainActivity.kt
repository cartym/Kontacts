package com.example.carty.kontacts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testContacts = arrayOf(
                Contact("test name", arrayOf(2042222222), arrayOf("test@gmail.com"), "01-01-2017"),
                Contact("bob bobby", arrayOf(2041111111), arrayOf("cats@gmail.com"), "02-02-2017")
        )

        val listView = findViewById(R.id.contactsListView) as ListView
        listView.adapter = ContactListAdapter(testContacts, this)
    }
}
