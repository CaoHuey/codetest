package com.vaporstream.android_codetest.results

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.vaporstream.android_codetest.R

class ResultsActivity : AppCompatActivity() {
    private var firstName: String? = null
    private var lastName: String? = null
    private var phoneNumber: String? = null
    private var addressOne: String? = null
    private var addressTwo: String? = null
    private var city: String? = null
    private var state: String? = null
    private var zipCode: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        val extras = intent.extras
        if (extras != null) {
            firstName = extras.getString(FIRST_NAME)
            lastName = extras.getString(LAST_NAME)
            phoneNumber = extras.getString(PHONE_NUMBER)
            addressOne = extras.getString(ADDRESS_ONE)
            addressTwo = extras.getString(ADDRESS_TWO)
            city = extras.getString(CITY)
            state = extras.getString(STATE)
            zipCode = extras.getString(ZIPCODE)
        }
        val firstNameTextView = findViewById<TextView>(R.id.text_view_first_name)
        val lastNameTextView = findViewById<TextView>(R.id.text_view_last_name)
        val phoneNumberTextView = findViewById<TextView>(R.id.text_view_phone_number)
        val addressOneTextView = findViewById<TextView>(R.id.text_view_address_one)
        val addressTwoTextView = findViewById<TextView>(R.id.text_view_address_two)
        val cityTextView = findViewById<TextView>(R.id.text_view_city)
        val stateTextView = findViewById<TextView>(R.id.text_view_state)
        val zipCodeTextView = findViewById<TextView>(R.id.text_view_zip_code)
        firstNameTextView.text = firstName
        lastNameTextView.text = lastName
        phoneNumberTextView.text = phoneNumber
        addressOneTextView.text = addressOne
        addressTwoTextView.text = addressTwo
        cityTextView.text = city
        stateTextView.text = state
        zipCodeTextView.text = zipCode
    }

    companion object {
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
        const val PHONE_NUMBER = "phone_number"
        const val ADDRESS_ONE = "address_one"
        const val ADDRESS_TWO = "address_two"
        const val CITY = "city"
        const val STATE = "state"
        const val ZIPCODE = "zipcode"
    }
}