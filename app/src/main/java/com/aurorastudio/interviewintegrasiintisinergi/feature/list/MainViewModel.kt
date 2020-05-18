package com.aurorastudio.interviewintegrasiintisinergi.feature.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aurorastudio.interviewintegrasiintisinergi.data.SampleData
import com.aurorastudio.interviewintegrasiintisinergi.data.local.EventDao
import com.aurorastudio.interviewintegrasiintisinergi.data.local.SortOptionDao

/**
 *
 * Created by Rio on 18/05/20.
 * Email rio.aska35@gmail.com
 *
 */
class MainViewModel: ViewModel() {

    private val _listData = MutableLiveData<List<EventDao>>()
    val listData: LiveData<List<EventDao>> get() = _listData

    private val listEvent = mutableListOf<EventDao>()

    private val _listOptionSort = MutableLiveData<List<SortOptionDao>>()
    val listOptionSort: LiveData<List<SortOptionDao>> get() = _listOptionSort

    init {
        listEvent.addAll(SampleData().listEventSample)
        _listOptionSort.value = SampleData().listSortOptionSample
        _listData.value = listEvent
    }

    fun selectedOptionSort(id: String) {
        resetOptionSort()
        val list = _listOptionSort.value
        list?.find { it.id == id }?.selected = true
        _listOptionSort.value = list
    }

    private fun resetOptionSort() {
        val list = _listOptionSort.value
        list?.find { it.selected }?.selected = false
        _listOptionSort.value = list
    }


}