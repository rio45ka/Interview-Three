package com.aurorastudio.interviewintegrasiintisinergi.feature.list.sort

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aurorastudio.interviewintegrasiintisinergi.R
import com.aurorastudio.interviewintegrasiintisinergi.data.local.SortOptionDao
import com.aurorastudio.interviewintegrasiintisinergi.databinding.ItemOptionSortBinding

/**
 *
 * Created by Rio on 18/05/20.
 * Email rio.aska35@gmail.com
 *
 */
class SortOptionAdapter(private val onClickListener: OnClickListener)
    : ListAdapter<SortOptionDao, SortOptionAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemOptionSortBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            SortOptionAdapter.ViewHolder.LAYOUT,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onClickListener.onClick(getItem(position))
        }
        holder.bind(getItem(position))
    }

    class ViewHolder(private var binding: ItemOptionSortBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            @LayoutRes
            val LAYOUT = R.layout.item_option_sort
        }

        fun bind(item: SortOptionDao) {
            binding.option = item
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<SortOptionDao>() {

        override fun areItemsTheSame(oldItem: SortOptionDao, newItem: SortOptionDao): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: SortOptionDao, newItem: SortOptionDao): Boolean {
            return oldItem.id == newItem.id
        }
    }

}

class OnClickListener(val clickListener: (item: SortOptionDao) -> Unit) {
    fun onClick(item: SortOptionDao) = clickListener(item)
}