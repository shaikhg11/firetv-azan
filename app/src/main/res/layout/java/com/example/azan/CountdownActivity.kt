package com.example.azan

import android.os.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CountdownActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countdown)

        val prayerName = intent.getStringExtra("PRAYER_NAME")
        val timerText = findViewById<TextView>(R.id.countdownText)

        object : CountDownTimer(60000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                timerText.text = "$prayerName Azan in\n$seconds"
            }

            override fun onFinish() {
                finish()
            }

        }.start()
    }
}