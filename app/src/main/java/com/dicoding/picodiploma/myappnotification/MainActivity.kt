package com.dicoding.picodiploma.myappnotification

import android.app.Notification.EXTRA_NOTIFICATION_ID
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = NotificationManagerCompat.from(this)

        val myImage = BitmapFactory.decodeResource(
            applicationContext.resources,
            R.drawable.reminder1
        )
        val bigPictureStyle = NotificationCompat.BigPictureStyle()
            .bigPicture(myImage)
            .bigLargeIcon(null)


        btnSend1.setOnClickListener {
            val title = etTitle.text.toString()
            val message = etMessage.text.toString()
            val builder = NotificationCompat.Builder(this,BaseApplication.CHANNEL_1_ID)
                    .setSmallIcon(R.drawable.ic_favorite)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setLargeIcon(myImage)
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setSubText(etTitle.text.toString())
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setStyle(NotificationCompat.BigPictureStyle()
                    .bigPicture(myImage)
                    .bigLargeIcon(null))

            val notification = builder.build()
            notificationManager.notify(1, notification)

        }

        btnSend2.setOnClickListener {
            val title = etTitle.text.toString()
            val message = etMessage.text.toString()
            val builder = NotificationCompat.Builder(this,BaseApplication.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_favorite)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(myImage)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setSubText(etTitle.text.toString())
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setStyle(NotificationCompat.BigPictureStyle()
                    .bigPicture(myImage)
                    .bigLargeIcon(null))

            val notification = builder.build()
            notificationManager.notify(2, notification)
        }
    }
}