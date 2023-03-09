package com.example.broadcastrreceiver


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.broadcastreceiver.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val serviceIntent = Intent(this, AutoReplyService::class.java)
        startService(serviceIntent)

    }
    fun saveAutoReply(view: View) {
        val phoneNumber = findViewById<EditText>(R.id.phoneNumberEditText).text.toString()
        val message = findViewById<EditText>(R.id.messageEditText).text.toString()

        val sharedPreferences = getSharedPreferences("AutoReply", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("phoneNumber", phoneNumber)
        editor.putString("message", message)
        editor.apply()

        Toast.makeText(this, "Auto-reply settings saved", Toast.LENGTH_SHORT).show()
    }


}