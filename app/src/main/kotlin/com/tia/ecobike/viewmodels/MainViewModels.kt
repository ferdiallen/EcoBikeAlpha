package com.tia.ecobike.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModels:ViewModel() {
    private val _scrolled = MutableLiveData(false)
    val scrolled:LiveData<Boolean> = _scrolled

    fun setScrolled(data:Boolean){
        _scrolled.postValue(data)
    }
}