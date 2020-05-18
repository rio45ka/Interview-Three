package com.aurorastudio.interviewintegrasiintisinergi.feature.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aurorastudio.interviewintegrasiintisinergi.data.SampleData
import com.aurorastudio.interviewintegrasiintisinergi.data.local.EventDao

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

    init {
        listEvent.addAll(SampleData().listEventSample)
        _listData.value = listEvent
    }


}