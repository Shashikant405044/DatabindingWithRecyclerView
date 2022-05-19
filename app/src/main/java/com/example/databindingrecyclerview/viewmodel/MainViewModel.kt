package com.example.databindingrecyclerview.viewmodel

import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.databindingrecyclerview.model.DataModel


class MainViewModel : ViewModel() {

    var firstData = MutableLiveData<List<DataModel>>()
    var newList =  arrayListOf<DataModel>()


    fun add(dataModel: DataModel){
        newList.add(dataModel)
        firstData.value = newList
    }

   /* fun  remove(dataModel: List<DataModel>){
        newList.remove(dataModel)
        firstData.value = newList

    }*/


}