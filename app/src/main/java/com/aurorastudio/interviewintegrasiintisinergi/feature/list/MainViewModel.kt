package com.aurorastudio.interviewintegrasiintisinergi.feature.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aurorastudio.interviewintegrasiintisinergi.data.SampleData
import com.aurorastudio.interviewintegrasiintisinergi.data.local.EventDao
import com.aurorastudio.interviewintegrasiintisinergi.data.local.SortOptionDao
import java.time.LocalDate

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

    private val _statusSort = MutableLiveData<Int>()
    val statusSort: LiveData<Int> get() = _statusSort

    init {
        listEvent.addAll(SampleData().listEventSample)
        _listData.value = listEvent
        resetOptionSort()

        _statusSort.value = -1
    }

    fun selectedOptionSort(id: String) {
        resetOptionSort()
        val list = _listOptionSort.value
        list?.find { it.id == id }?.selected = true
        _listOptionSort.value = list

        actionSortEvent(id.toInt())
    }

    private fun resetOptionSort() {
        _listOptionSort.value = SampleData().listSortOptionSample
    }

    private fun sortByDate() {
        val list = listEvent
        val sorted = list.sortedBy { it.dateTimeStart }
        _listData.value = sorted
    }

    private fun sortByIsRead() {
        val list = listEvent
        val sorted = list.sortedBy { it.isRead }
        _listData.value = sorted
    }

    private fun actionSortEvent(type: Int) {
        updateStatusSort(type)
        when (type) {
            1 -> _listData.value = listEvent
            2 -> sortByDate()
            3 -> sortByIsRead()
        }
    }

    private fun updateStatusSort(type: Int) {
        _statusSort.value = type
    }


}