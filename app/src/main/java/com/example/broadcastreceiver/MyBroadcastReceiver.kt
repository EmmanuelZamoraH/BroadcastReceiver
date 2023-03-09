package com.example.broadcastrreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.telephony.SmsManager
import android.telephony.TelephonyManager
import android.util.Log


class MyBroadcastReceiver: BroadcastReceiver() {
    private lateinit var phoneNumber: String
    private lateinit var message: String
    override fun onReceive(context: Context, intent: Intent) {
        var sharedPreferences =
            context.getSharedPreferences("AutoReply", Context.MODE_PRIVATE);
        val phoneNumber = sharedPreferences.getString("phoneNumber", "")
        val message = sharedPreferences.getString("message", "")
        Log.d("numero ",phoneNumber.toString())
        Log.d("mensaje ",message.toString())
        if (intent.action == TelephonyManager.ACTION_PHONE_STATE_CHANGED) {
            val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val state = telephonyManager.callState
            val incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
            if (state == TelephonyManager.CALL_STATE_RINGING) {
                if(incomingNumber.toString()==phoneNumber){
                    val smsManager = SmsManager.getDefault()
                    smsManager.sendTextMessage(incomingNumber.toString(), null, message,null, null)
                }
                Log.d("numero", incomingNumber.toString())

            }
        }
    }
}