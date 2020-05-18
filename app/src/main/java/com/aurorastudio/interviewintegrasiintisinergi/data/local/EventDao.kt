package com.aurorastudio.interviewintegrasiintisinergi.data.local

import android.os.Parcelable
import com.aurorastudio.interviewintegrasiintisinergi.util.convertStringToDate
import com.aurorastudio.interviewintegrasiintisinergi.util.formatDate
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 *
 * Created by Rio on 18/05/20.
 * Email rio.aska35@gmail.com
 *
 */
@Parcelize
data class EventDao(

    val id: String,

    val title: String,

    val nameStudent: String,

    val school: String,

    val dateEventStart: String,

    val dateEventFinish: String,

    val confirmationOfAttendance: String,

    val isRead: Boolean

): Parcelable {
    val isAttendance: Boolean get() = confirmationOfAttendance == "yes"
    val dateTimeStart: Date get() = convertStringToDate(dateEventStart)!!
}