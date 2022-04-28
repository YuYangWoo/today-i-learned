package com.example.fcm_push

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class PushJobIntentService : JobIntentService() {
    private val JOB_ID = 1001
    private val TAG = "PushJobIntentService"

    fun enqueWork(context: Context, work: Intent) {
        enqueueWork(context, PushJobIntentService::class.java, JOB_ID, work)
    }

    override fun onHandleWork(intent: Intent) {
        val myFirebaseMessagingService = MyFirebaseMessagingService()
        try {
            myFirebaseMessagingService.sendNotification(
                applicationContext,
                intent.getStringExtra("title"),
                intent.getStringExtra("body")
            )
        } catch (e: Exception) {
            Log.d(TAG, e.message.toString())
        }
    }

}
