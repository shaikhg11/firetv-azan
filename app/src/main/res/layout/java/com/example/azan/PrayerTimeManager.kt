package com.example.azan

import com.batoulapps.adhan.*
import java.time.LocalDate

object PrayerTimeManager {

    fun getTodayPrayerTimes(): Map<String, Long> {

        val coordinates = Coordinates(29.7604, -95.3698)
        val params = CalculationMethod.NORTH_AMERICA.parameters
        val date = DateComponents.from(LocalDate.now())

        val prayerTimes = PrayerTimes(coordinates, date, params)

        return mapOf(
            "FAJR" to prayerTimes.fajr.time,
            "DHUHR" to prayerTimes.dhuhr.time,
            "ASR" to prayerTimes.asr.time,
            "MAGHRIB" to prayerTimes.maghrib.time,
            "ISHA" to prayerTimes.isha.time
        )
    }
}