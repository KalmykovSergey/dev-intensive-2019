package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd:MM:yy") : String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND) : Date{
    var time = this.time
    time += when (units){
        TimeUnits.SECOND-> value * SECOND
        TimeUnits.MINUTE-> value * MINUTE
        TimeUnits.HOUR-> value * HOUR
        TimeUnits.DAY-> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
    val timeDelta = Date().time-this.time
    var humanDate: String = ""
    if (timeDelta >= 0){
        if (timeDelta < 1 * SECOND) humanDate = "только что"
        else if (timeDelta < 45 * SECOND) humanDate = "несколько секунд назад"
        else if (timeDelta < 75 * SECOND) humanDate = "минуту назад"
        else if (timeDelta < 45 * MINUTE) {
            val numMinutes: Int = (timeDelta / MINUTE).toInt()
            var literMinutes = "минут"
            if (numMinutes in 2..4 || numMinutes % 10 in 2..4 && numMinutes > 21) literMinutes = "минуты"
            else if (numMinutes % 10 == 1 && numMinutes > 20) literMinutes = "минуту"
            humanDate = "$numMinutes $literMinutes назад"
        }
        else if (timeDelta < 75 * MINUTE) humanDate = "час назад"
        else if (timeDelta < 22 * HOUR) {
            val numHours: Int = (timeDelta / HOUR).toInt()
            var literHours = "часов"
            if (numHours in 2..4 || numHours % 10 in 2..4 && numHours > 21) literHours = "часа"
            else if (numHours % 10 == 1 && numHours > 20) literHours = "час"
            humanDate = "$numHours $literHours назад"
        }
        else if (timeDelta < 26 * HOUR) humanDate = "день назад"
        else if (timeDelta < 260 * DAY) {
            val numDays: Int = (timeDelta / DAY).toInt()
            var literDays = "дней"
            if (numDays in 2..4 || numDays % 10 in 2..4 && numDays > 21) literDays = "дня"
            else if (numDays % 10 == 1 && numDays > 20) literDays = "день"
            humanDate = "$numDays $literDays назад"
        }
        else humanDate = "более года назад"
    }

    return humanDate
}


enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY;
}



//TimeUnits.SECOND.plural(1) //1 секунду
//TimeUnits.MINUTE.plural(4) //4 минуты
//TimeUnits.HOUR.plural(19) //19 часов
//TimeUnits.DAY.plural(222) //222 дня