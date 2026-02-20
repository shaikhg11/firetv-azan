package com.example.azan

import android.content.*

class CountdownReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val launchIntent =
            Intent(context, CountdownActivity::class.java)

        launchIntent.putExtra(
            "PRAYER_NAME",
            intent.getStringExtra("PRAYER_NAME")
        )

        launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(launchIntent)
    }
}