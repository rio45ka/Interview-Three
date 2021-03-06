package com.aurorastudio.interviewintegrasiintisinergi.feature.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.aurorastudio.interviewintegrasiintisinergi.R
import com.aurorastudio.interviewintegrasiintisinergi.data.local.SortOptionDao
import com.aurorastudio.interviewintegrasiintisinergi.databinding.ActivityMainBinding
import com.aurorastudio.interviewintegrasiintisinergi.feature.list.sort.SortBottomSheetFragment
import kotlinx.android.synthetic.main.app_bar.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.listEvent.adapter = EventListAdapter()

        binding.appbarMain.tvTitleCustomToolbar.text = getString(R.string.title_toolbar_main)

        binding.btnSort.setOnClickListener {
            val bottomSheet = SortBottomSheetFragment()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }

}
