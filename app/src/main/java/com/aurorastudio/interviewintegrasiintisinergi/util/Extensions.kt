package com.aurorastudio.interviewintegrasiintisinergi.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * Created by Rio on 18/05/20.
 * Email rio.aska35@gmail.com
 *
 */
internal fun getLocalId(): Locale {
    return Locale("id", "ID")
}

internal fun formatDate(inputDate: String): String {
    val parsed: Date?
    var outputDate = ""
    val dfInput = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", getLocalId())
    val dfOutput = SimpleDateFormat("dd MMMM", getLocalId())
    try {
        parsed = dfInput.parse(inputDate)
        outputDate = dfOutput.format(parsed!!)

    } catch (e: ParseException) {
        println("${e.message}")
    }
    return outputDate
}

internal fun convertStringToDate(inputDate: String): Date? {
    var parsed: Date? = Date()
    val dfInput = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", getLocalId())
    try {
        parsed = dfInput.parse(inputDate)
    } catch (e: ParseException) {
        println("${e.message}")
    }
    return parsed
}

internal fun formatTimeEvent(inputDateStart: String, inputDateFinish: String): String {
    var result = ""
    val dfInput = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", getLocalId())
    val dfOutput = SimpleDateFormat("HH.mm", getLocalId())
    try {
        val parsedDateStart = dfInput.parse(inputDateStart)
        val parsedDateFinish = dfInput.parse(inputDateFinish)
        val outputDateStart = dfOutput.format(parsedDateStart!!)
        val outputDateFinish = dfOutput.format(parsedDateFinish!!)
        result = "$outputDateStart - $outputDateFinish"

    } catch (e: ParseException) {
        println("${e.message}")
    }
    return result
}