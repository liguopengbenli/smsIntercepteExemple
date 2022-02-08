package com.example.smsintercepte

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.widget.Toast


class ReceiveSms : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            if (intent.action.equals("android.provider.Telephony.SMS_RECEIVED")) {
                val smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
                for (message in smsMessages) {
                    val msgFrom = message.displayOriginatingAddress
                    val msgBody = message.messageBody
                    Toast.makeText(context, "From $msgFrom body: $msgBody", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }

    }
}