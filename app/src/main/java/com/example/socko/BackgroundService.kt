package com.example.socko

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.widget.RemoteViews

class BackgroundService : Service(){

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelID = "com.example.socko"
    private val description = "Sockos grosser Tag"
    val state = 2

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        setState(this, state)

        val intent = Intent(this, StageThree::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val contentView = RemoteViews(packageName, R.layout.notification_layout)
        contentView.setTextViewText(R.id.tv_title,"Heute ist Sockos grosser Tag!")
        contentView.setTextViewText(R.id.tv_content, "Socko wird heute getragen.\nSei dabei!")

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelID, description, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this, channelID)
                .setContent(contentView)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.mipmap.ic_launcher))
                .setContentIntent(pendingIntent)
        }else{
            builder = Notification.Builder(this)
                .setContent(contentView)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.mipmap.ic_launcher))
                .setContentIntent(pendingIntent)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.sound_notification)
            notificationManager.notify(1234, builder.build())
            mediaPlayer.start()
        }

        stopSelf()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}