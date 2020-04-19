package com.example.socko

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import java.util.*

class BootCompleteReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action.equals("android.intent.action.BOOT_COMPLETED")){
            val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val startServiceIntent = Intent(context, BackgroundService::class.java)
            val startServicePendingIntent = PendingIntent.getService(context,0, startServiceIntent,0)

            var calendar = Calendar.getInstance()
            calendar.timeInMillis = getTime(context)

            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, startServicePendingIntent)
        }
    }

}