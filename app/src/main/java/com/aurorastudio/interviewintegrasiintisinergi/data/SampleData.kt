package com.aurorastudio.interviewintegrasiintisinergi.data

import com.aurorastudio.interviewintegrasiintisinergi.data.local.EventDao
import com.aurorastudio.interviewintegrasiintisinergi.data.local.SortOptionDao

/**
 *
 * Created by Rio on 18/05/20.
 * Email rio.aska35@gmail.com
 *
 */
class SampleData {
    val listEventSample = listOf<EventDao>(
        EventDao(
            "1",
            "Gladi Bersih Lomba Tari",
            "Kevin Himawan",
            "TK Bintang Kecil Jakarta",
            "2020-12-20 09:00:00",
            "2020-12-20 10:00:00",
            "yes",
            true
        ),
        EventDao(
            "2",
            "Gladi Bersih Lomba Tari",
            "Kevin Himawan",
            "TK Bintang Kecil Jakarta",
            "2020-12-25 09:00:00",
            "2020-12-25 10:00:00",
            "maybe",
            false
        ),
        EventDao(
            "3",
            "Gladi Bersih Lomba Tari",
            "Kevin Himawan",
            "TK Bintang Kecil Jakarta",
            "2020-12-27 09:00:00",
            "2020-12-27 10:00:00",
            "maybe",
            false
        ),
        EventDao(
            "4",
            "Gladi Bersih Lomba Tari",
            "Kevin Himawan",
            "TK Bintang Kecil Jakarta",
            "2020-12-22 11:00:00",
            "2020-12-22 12:00:00",
            "maybe",
            false
        ),
        EventDao(
            "5",
            "Gladi Bersih Lomba Tari",
            "Kevin Himawan",
            "TK Bintang Kecil Jakarta",
            "2020-12-23 09:00:00",
            "2020-12-23 10:00:00",
            "maybe",
            true
        ),
        EventDao(
            "6",
            "Gladi Bersih Lomba Tari",
            "Kevin Himawan",
            "TK Bintang Kecil Jakarta",
            "2020-12-23 13:00:00",
            "2020-12-23 15:00:00",
            "maybe",
            false
        ),
        EventDao(
            "7",
            "Gladi Bersih Lomba Tari",
            "Kevin Himawan",
            "TK Bintang Kecil Jakarta",
            "2020-12-24 09:00:00",
            "2020-12-24 10:00:00",
            "maybe",
            true
        )
    )

    val listSortOptionSample = listOf<SortOptionDao>(
        SortOptionDao(
            "Terbaru dibagikan",
            "1",
            false
        ),
        SortOptionDao(
            "Tanggal kegiatan terdekat",
            "2",
            false
        ),
        SortOptionDao(
            "Belum dibaca",
            "3",
            false
        )
    )
}