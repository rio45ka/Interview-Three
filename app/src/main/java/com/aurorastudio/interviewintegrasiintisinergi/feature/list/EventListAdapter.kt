package com.aurorastudio.interviewintegrasiintisinergi.feature.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aurorastudio.interviewintegrasiintisinergi.R
import com.aurorastudio.interviewintegrasiintisinergi.data.local.EventDao
import com.aurorastudio.interviewintegrasiintisinergi.databinding.ItemEventBinding

/**
 *
 * Created by Rio on 18/05/20.
 * Email rio.aska35@gmail.com
 *
 */
class EventListAdapter : ListAdapter<EventDao, EventListAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemEventBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            ViewHolder.LAYOUT,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private var binding: ItemEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            @LayoutRes
            val LAYOUT = R.layout.item_event
        }

        fun bind(event: EventDao) {
            binding.event = event
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<EventDao>() {

        override fun areItemsTheSame(oldItem: EventDao, newItem: EventDao): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: EventDao, newItem: EventDao): Boolean {
            return oldItem.id == newItem.id
        }
    }

}