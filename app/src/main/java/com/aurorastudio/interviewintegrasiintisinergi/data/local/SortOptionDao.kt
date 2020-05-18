package com.aurorastudio.interviewintegrasiintisinergi.data.local

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *
 * Created by Rio on 18/05/20.
 * Email rio.aska35@gmail.com
 *
 */
@Parcelize
data class SortOptionDao(

    val title: String,

    val id: String,

    var selected: Boolean

): Parcelable