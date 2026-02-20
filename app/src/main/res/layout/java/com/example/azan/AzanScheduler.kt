package com.example.azan

import android.app.*
import android.content.*
import java.util.*

object AzanScheduler {

    fun scheduleAllPrayers(context: Context) {

        val prayerTimes = PrayerTimeManager.getTodayPrayerTimes()

        prayerTimes.forEach { (name, timeMillis) ->

            if (timeMillis > System.currentTimeMillis()) {

                scheduleAzan(context, name, timeMillis)

                if (name == "FAJR" || name == "MAGHRIB") {
                    scheduleCountdown(context, name, timeMillis - 60000)
                }
            }
        }
    }

    private fun scheduleAzan(context: Context, name: String, timeMillis: Long) {

        val intent = Intent(context, AzanReceiver::class.java)
        intent.putExtra("PRAYER_NAME", name)

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            name.hashCode(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val alarmManager =
            context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            timeMillis,
            pendingIntent
        )
    }

    private fun scheduleCountdown(context: Context, name: String, timeMillis: Long) {

        val intent = Intent(context, CountdownReceiver::class.java)
        intent.putExtra("PRAYER_NAME", name)

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            (name + "_COUNTDOWN").hashCode(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val alarmManager =
            context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            timeMillis,
            pendingIntent
        )
    }
}