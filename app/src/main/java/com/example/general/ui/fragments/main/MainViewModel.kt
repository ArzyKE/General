package com.example.general.ui.fragments.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.general.data.models.Model

class MainViewModel : ViewModel() {

    val liveData = MutableLiveData<ArrayList<Model>>()
    val list = ArrayList<Model>()

    init {
        createData()
    }

    private fun createData() {
        list.add(Model("jdlkf", "dflkd"))
        list.add(Model("dsafafd", "dflkd"))
        list.add(Model("were", "dflkd"))
        list.add(Model("tr", "dflkd"))
        list.add(Model("wew", "dflkd"))
        liveData.value = list
    }
}