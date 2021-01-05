package com.rs132studio.passingdatakt

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_show_info.*

class ShowInfo : AppCompatActivity() {
    val CHANNEL_ID = "channel_id"
    val CHANNEL_NAME = "channel_name"
    val NOTIFICATION_ID = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_info)

        val name = intent.getStringExtra("PERSON_NAME")
        val country = intent.getStringExtra("PERSON_COUNTRY")
        val phone = intent.getStringExtra("PERSONAL_NUMBER")

        val fullText = "Enter person name is $name, who is from $country and his phone number is $phone"

        info_txtView.text = fullText

        val intent = Intent(this, ShowInfo::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        createNotificationChannel()

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Notification Received")
            .setContentText("You received a awesome notification from your training app")
            .setSmallIcon(R.drawable.ic_baseline_notifications)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)

        notification_btn.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID, notification)
        }


    }

    //*********notification*********

    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH).apply {
                lightColor = Color.RED
                enableLights(true)
            }

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}