package com.aurorastudio.interviewintegrasiintisinergi.feature.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aurorastudio.interviewintegrasiintisinergi.getOrAwaitValue
import com.google.common.base.CharMatcher.`is`
import org.hamcrest.CoreMatchers
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

/**
 * Created by Rio on 19/05/20.
 * Email rio.aska35@gmail.com
 */
@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @get: Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        viewModel = MainViewModel()
    }


    @Test
    fun getListData() {
        val value = viewModel.listData.getOrAwaitValue()

    }

    @Test
    fun getFilter() {
        viewModel.selectedOptionSort("1")

    }


}