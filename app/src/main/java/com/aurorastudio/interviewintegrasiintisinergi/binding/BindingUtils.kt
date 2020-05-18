package com.aurorastudio.interviewintegrasiintisinergi.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aurorastudio.interviewintegrasiintisinergi.data.local.EventDao
import com.aurorastudio.interviewintegrasiintisinergi.feature.list.EventListAdapter
import com.aurorastudio.interviewintegrasiintisinergi.util.formatDate
import com.aurorastudio.interviewintegrasiintisinergi.util.formatTimeEvent

/**
 *
 * Created by Rio on 18/05/20.
 * Email rio.aska35@gmail.com
 *
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<EventDao>?) {
    val adapter = recyclerView.adapter as EventListAdapter
    adapter.submitList(data)
}


@BindingAdapter("setDateEvent")
fun TextView.setDateEventText(item: EventDao?) {
    item?.let {
        text = formatDate(item.dateEventStart)
    }
}


@BindingAdapter("setTimeEvent")
fun TextView.setTimeEventText(item: EventDao?) {
    item?.let {
        text = formatTimeEvent(item.dateEventStart, item.dateEventFinish)
    }
}