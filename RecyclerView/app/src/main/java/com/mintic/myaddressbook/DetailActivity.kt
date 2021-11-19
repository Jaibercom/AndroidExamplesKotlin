package com.mintic.myaddressbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        Log.d(TAG, "onCreate")
        val name = intent.getStringExtra(ListActivity.KEY_NAME)
        val lastname = intent.getStringExtra(ListActivity.KEY_LAST_NAME)
        val contact = intent.getParcelableExtra<Contact>(ListActivity.KEY_CONTACT)

        Log.d(TAG, "Name: $name")
        Log.d(TAG, "Last Name: $lastname")
        Log.d(TAG, "Contact: $contact")
    }

    companion object {
        private val TAG = DetailActivity::class.java.simpleName
    }
}