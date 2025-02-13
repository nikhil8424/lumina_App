package com.example.lumina.services

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.lumina.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FCMessagingService : FirebaseMessagingService() {

    companion object {
        private const val CHANNEL_ID = "writer_allotment_channel"
        private const val NOTIFICATION_ID = 1
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        // Extract notification data
        remoteMessage.notification?.let {
            showNotification(it.title, it.body)
        }

        // Handle data if needed
        val allotmentId = remoteMessage.data["allotmentId"]
        // Process the allotmentId as needed
    }

    private fun fetchDataFromFirebase() {
        val userType = ""
        if (userType == "admin") {
            // Handle admin-specific data fetching
        }
    }

    private fun fetchDataForWriter() {
        // Handle writer-specific data fetching
    }

    private fun showNotification(title: String?, body: String?) {
        // Create a notification channel (if necessary)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Writer Allotment Notifications",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notifications about writer allotments"
            }

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }

        // Check permission for posting notifications
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
        ) {
            Log.e("FCMessagingService", "Notification permission not granted.")
            return
        }

        // Create and show the notification
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.logo)
            .setContentTitle(title)
            .setContentText(body)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FCMessagingService", "New token: $token")
    }
}
