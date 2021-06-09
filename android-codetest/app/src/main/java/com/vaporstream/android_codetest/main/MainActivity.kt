package com.vaporstream.android_codetest.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vaporstream.android_codetest.R
import com.vaporstream.android_codetest.results.ResultsActivity

class MainActivity : AppCompatActivity() {
    private var firstNameEditText: EditText? = null
    private var lastNameEditText: EditText? = null
    private var phoneNumberEditText: EditText? = null
    private var addressOneEditText: EditText? = null
    private var addressTwoEditText: EditText? = null
    private var cityEditText: EditText? = null
    private var spinnerStates: Spinner? = null
    private var zipCodeEditText: EditText? = null
    private var clearButton: Button? = null
    private var submitButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Binds the layout to my views, couldn't get this to function property after plenty of research!
        val binding: MyLayoutBinding? = MyLayoutBinding.inflate(layoutInflater)

        firstNameEditText = findViewById(R.id.edit_text_first_name)
        lastNameEditText = findViewById(R.id.edit_text_last_name)
        phoneNumberEditText = findViewById(R.id.edit_text_phone_number)
        addressOneEditText = findViewById(R.id.edit_text_address_one)
        addressTwoEditText = findViewById(R.id.edit_text_address_two)
        cityEditText = findViewById(R.id.edit_text_city)
        spinnerStates = findViewById(R.id.spinner_states)
        zipCodeEditText = findViewById(R.id.edit_text_zipcode)
        clearButton = findViewById(R.id.button_clear)
        submitButton = findViewById(R.id.button_submit)
        val statesAdapter = ArrayAdapter.createFromResource(this, R.array.states_array, android.R.layout.simple_spinner_dropdown_item)
        statesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerStates?.adapter = statesAdapter;
        clearButton?.setOnClickListener(View.OnClickListener { clearForm() })
        submitButton?.setOnClickListener(View.OnClickListener { submitForm() })

        //Setup for the observable live data
        val viewModel : LiveDataViewModel
        viewModel = ViewModelProvider(this).get(LiveDataViewModel::class.java)
        viewModel._FirstName.observe(this, { newName-> })
    }

    private fun clearForm() {
        firstNameEditText?.setText("")
        lastNameEditText?.setText("")
        phoneNumberEditText?.setText("")
        addressOneEditText?.setText("")
        addressTwoEditText?.setText("")
        cityEditText?.setText("")
        spinnerStates?.setSelection(0)
        zipCodeEditText?.setText("")
    }

    private fun submitForm() {
        //if databinding had worked in onCreate, would have used the observer to encapsulate the live data
        val user = UserModel(firstNameEditText?.text.toString(),
                lastNameEditText?.text.toString(),
                phoneNumberEditText?.text.toString().toInt(),
                addressOneEditText?.text.toString(),
                addressTwoEditText?.text.toString(),
                cityEditText?.text.toString(),
                spinnerStates!!.selectedItem.toString(),
                zipCodeEditText!!.text.toString().toInt())

        val resultsIntent = Intent(this, ResultsActivity::class.java)
        resultsIntent.putExtra(ResultsActivity.FIRST_NAME, firstNameEditText!!.text.toString())
        resultsIntent.putExtra(ResultsActivity.LAST_NAME, lastNameEditText!!.text.toString())
        resultsIntent.putExtra(ResultsActivity.PHONE_NUMBER, phoneNumberEditText!!.text.toString())
        resultsIntent.putExtra(ResultsActivity.ADDRESS_ONE, addressOneEditText!!.text.toString())
        resultsIntent.putExtra(ResultsActivity.ADDRESS_TWO, addressTwoEditText!!.text.toString())
        resultsIntent.putExtra(ResultsActivity.CITY, cityEditText!!.text.toString())
        resultsIntent.putExtra(ResultsActivity.STATE, spinnerStates!!.selectedItem.toString())
        resultsIntent.putExtra(ResultsActivity.ZIPCODE, zipCodeEditText!!.text.toString())
        startActivity(resultsIntent)
    }
}