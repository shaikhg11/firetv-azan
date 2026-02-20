package com.example.azan

import android.os.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var clockText: TextView
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clockText = findViewById(R.id.clockText)

        startClock()
        AzanScheduler.scheduleAllPrayers(this)
    }

    private fun startClock() {
        handler.post(object : Runnable {
            override fun run() {
                val formatter =
                    SimpleDateFormat("hh:mm:ss a", Locale.US)
                formatter.timeZone =
                    TimeZone.getTimeZone("America/Chicago")

                clockText.text = formatter.format(Date())
                handler.postDelayed(this, 1000)
            }
        })
    }
}