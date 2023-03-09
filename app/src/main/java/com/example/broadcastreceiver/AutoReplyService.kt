package com.example.broadcastrreceiver

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import android.preference.PreferenceManager
import android.telephony.SmsManager
import android.telephony.TelephonyManager
import android.util.Log


class AutoReplyService : Service() {

    val br : BroadcastReceiver = MyBroadcastReceiver()
    val intentFilter: IntentFilter = IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED)

    override fun onBind(p0: Intent?): IBinder? {
        //TODO("Not yet implemented")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        registerReceiver(br, intentFilter)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(br)
    }
}