package com.vaporstream.android_codetest.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel : ViewModel() {
    //Used to observe changes within the view
    val _FirstName : MutableLiveData<String> = MutableLiveData()
    private val _LastName : MutableLiveData<String> = MutableLiveData()
    private val phoneNumber : MutableLiveData<Int> = MutableLiveData()
    private val address1 : MutableLiveData<String> = MutableLiveData()
    private val address2 : MutableLiveData<String> = MutableLiveData()
    private val city : MutableLiveData<String> = MutableLiveData()
    private val state : MutableLiveData<String> = MutableLiveData()
    private val zip : MutableLiveData<Int> = MutableLiveData()

    init {
        _FirstName.value = ""
        _LastName.value = ""
        phoneNumber.value = 0
        address1.value = ""
        address2.value = ""
        city.value = ""
        state.value = ""
        zip.value = 0
    }

    //Populate data from model
    fun onSubmit(user : UserModel) {
        _FirstName.value = user.firstName
        _LastName.value = user.lastName
        phoneNumber.value = user.phoneNumber
        address1.value = user.address1
        address2.value = user.address2
        city.value = user.city
        state.value = user.state
        zip.value = user.zip
    }


}