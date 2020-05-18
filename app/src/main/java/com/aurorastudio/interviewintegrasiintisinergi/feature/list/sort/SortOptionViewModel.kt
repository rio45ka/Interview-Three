package com.aurorastudio.interviewintegrasiintisinergi.feature.list.sort

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aurorastudio.interviewintegrasiintisinergi.data.local.SortOptionDao

/**
 *
 * Created by Rio on 18/05/20.
 * Email rio.aska35@gmail.com
 *
 */
class SortOptionViewModel: ViewModel() {
    var listOption = MutableLiveData<List<SortOptionDao>>()
}