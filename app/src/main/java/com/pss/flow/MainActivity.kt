package com.pss.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    companion object{
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        printUser()
        Log.d(TAG, "print user completed")

        //suspend
        CoroutineScope(Dispatchers.IO).launch {
            printUserList()
        }
        Log.d(TAG, "print userList completed for suspend fun")

    }

    private fun printUser(){
        userList.forEach{user ->
            Log.d(TAG, user)
        }
    }

    private suspend fun printUserList(){
        userList.forEach { user ->
            Log.d(TAG,user)
        }
    }
}