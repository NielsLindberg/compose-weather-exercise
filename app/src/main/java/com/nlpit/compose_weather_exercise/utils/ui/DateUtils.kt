package com.nlpit.compose_weather_exercise.utils.ui

import java.util.*

fun unixToDate(unix: Long?): Date? {
    if(unix == null) return null
    return Date(unix * 1000)
}

fun Date.longDate(): String {
    return java.text.SimpleDateFormat("MMMM, d").format(this)
}
fun Date.dayOfWeek(): String {
    return java.text.SimpleDateFormat("EEEE").format(this)
}
fun Date.hourMinute(): String {
    return java.text.SimpleDateFormat("kk:mm").format(this)
}