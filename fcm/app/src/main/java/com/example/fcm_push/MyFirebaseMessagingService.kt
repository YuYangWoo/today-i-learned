package com.example.fcm_push

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.provider.Settings
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val TAG = "FirebaseService"

    // 파이어베이스 서비스의 토큰을 가져온다
    override fun onNewToken(token: String) {
        Log.d(TAG, token)
    }

    // 새로운 FCM 메시지가 있을 때 메세지를 받는다
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val msgData = remoteMessage.data
        val body = msgData["body"]
        val title = msgData["title"]

        val intent = Intent()
        intent.putExtra("body", body)
        intent.putExtra("title", title)

        if(remoteMessage.data != null) {
//        PushJobIntentService.enqueWork(applicationContext, intent)
            sendNotification(body, title)
        }
    }

    // FCM 메시지를 보내는 메시지
    /**
     * Notification Message 앱이 포그라운드에 있을 때 코드가 전달된다.
     * Data Message 언제든 코드를 탄다.
     */
    fun sendNotification(body: String?, title: String?) {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            putExtra("Notification", body)
            putExtra("Notification",title)
        }

        var pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        val notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        /**
         * NotificationId와 ChannelId가 같지 않으면 Head-up 알람이 뜨지 않는다.
         */
        val notificationId = 1001
        createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_HIGH, false,
            getString(R.string.app_name), "App notification channel")

        val channelId = "$packageName-${getString(R.string.app_name)}"

        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val fullScreenPendingIntent = PendingIntent.getActivity(baseContext, 0,
            intent, PendingIntent.FLAG_UPDATE_CURRENT)

        // 푸시알람 부가설정
        var notificationBuilder = NotificationCompat.Builder(this,channelId)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setSound(notificationSound)
            .setContentIntent(pendingIntent)
            .setFullScreenIntent(fullScreenPendingIntent, true)
            .setTimeoutAfter(1500)

        var notificationManager: NotificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(notificationId, notificationBuilder.build())
    }

    // NotificationChannel 만드는 메서드
    private fun createNotificationChannel(context: Context, importance: Int, showBadge: Boolean,
                                          name: String, description: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "${context.packageName}-$name"
            val channel = NotificationChannel(channelId, name, importance)
            channel.description = description
            channel.setShowBadge(showBadge)

            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}
