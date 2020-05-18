package com.aurorastudio.interviewintegrasiintisinergi.binding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.marginTop
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aurorastudio.interviewintegrasiintisinergi.R
import com.aurorastudio.interviewintegrasiintisinergi.data.local.EventDao
import com.aurorastudio.interviewintegrasiintisinergi.data.local.SortOptionDao
import com.aurorastudio.interviewintegrasiintisinergi.feature.list.EventListAdapter
import com.aurorastudio.interviewintegrasiintisinergi.feature.list.sort.SortOptionAdapter
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


@BindingAdapter("listDataSort")
fun bindRecyclerViewSort(recyclerView: RecyclerView, data: List<SortOptionDao>?) {
    val adapter = recyclerView.adapter as SortOptionAdapter
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


@BindingAdapter("setTitleSort")
fun TextView.setTitleSort(type: Int) {
    if (type == -1) {
        visibility = View.GONE
    } else {
        visibility = View.VISIBLE
        when(type) {
            1 -> text = context.getString(R.string.sort_type_1)
            2 -> text = context.getString(R.string.sort_type_2)
            3 -> text = context.getString(R.string.sort_type_3)
        }
    }
}



@BindingAdapter("toggleIconSort")
fun bindStatusOptionSort(statusImageView: ImageView, status: SortOptionDao?) {
    when (status?.selected) {
        true -> statusImageView.setImageResource(R.drawable.ic_radio_button_on)
        false -> statusImageView.setImageResource(R.drawable.ic_radio_button_off)
    }
}