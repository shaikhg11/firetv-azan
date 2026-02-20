package com.example.azan

import android.content.*

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            AzanScheduler.scheduleAllPrayers(context)
        }
    }
}