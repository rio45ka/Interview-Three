package com.aurorastudio.interviewintegrasiintisinergi.feature.list.sort

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.aurorastudio.interviewintegrasiintisinergi.R
import com.aurorastudio.interviewintegrasiintisinergi.data.local.SortOptionDao
import com.aurorastudio.interviewintegrasiintisinergi.databinding.SortBottomSheetBinding
import com.aurorastudio.interviewintegrasiintisinergi.feature.list.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 *
 * Created by Rio on 18/05/20.
 * Email rio.aska35@gmail.com
 *
 */
class SortBottomSheetFragment(private val clickListener: OnOptionSortClick,
                              private val list: List<SortOptionDao>) : BottomSheetDialogFragment() {

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        BottomSheetDialog(requireContext(), theme)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: SortBottomSheetBinding = DataBindingUtil.inflate(inflater
            , R.layout.sort_bottom_sheet, container, false)

        val viewModel = ViewModelProviders.of(this).get(SortOptionViewModel::class.java)

        viewModel.listOption.value = list
        binding.sortViewModel = viewModel
        binding.lifecycleOwner = this

        binding.listSortOption.adapter = SortOptionAdapter(OnClickListener {
            clickListener.onClickSort(it)
            dismiss()
        })

        binding.ivCloseBottomSheet.setOnClickListener {
            dismiss()
        }

        return binding.root
    }

    interface OnOptionSortClick {
        fun onClickSort(option: SortOptionDao)
    }

}
