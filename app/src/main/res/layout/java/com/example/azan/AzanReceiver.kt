package com.example.azan

import android.content.*

class AzanReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val launchIntent =
            Intent(context, PlaybackActivity::class.java)

        launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(launchIntent)
    }
}