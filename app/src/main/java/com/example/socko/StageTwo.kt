package com.example.socko

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class StageTwo : AppCompatActivity() {
    var time = 20000
    val state = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.idlescreen)
        setState(this, state)
//        var time = (1..1000000).shuffled().first()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameIdle, Waeschekorb())
            .commit()

        val alarmManager = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val startServiceIntent = Intent(this, BackgroundService::class.java)
        val startServicePendingIntent = PendingIntent.getService(this,0, startServiceIntent,0)

        var calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()+time
        setTime(this, calendar.timeInMillis)

        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, startServicePendingIntent)
    }

    override fun onStart() {
        if (getState(this) == state){}
        else{startActivity(Intent(this, StageThree::class.java))}

        super.onStart()
    }

    override fun onUserInteraction() {
        if (getState(this) == state){}
        else{startActivity(Intent(this, StageThree::class.java))}
        super.onUserInteraction()
    }

    override fun onBackPressed() {}
}