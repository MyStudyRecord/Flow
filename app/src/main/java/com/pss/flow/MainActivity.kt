package com.pss.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    companion object{
        private const val TAG = "MainTag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   /*     printUser()
        Log.d(TAG, "print user completed")

        //suspend
        CoroutineScope(Dispatchers.IO).launch {
            printUserList()
        }
        Log.d(TAG, "print userList completed for suspend fun")*/

        //simple flow
        CoroutineScope(IO).launch {
            launch {
                simpleFlow().collect { user ->
                    Log.d(TAG, "Flow1 $user")
                }
            }
            launch {
                simpleFlow().collect { user ->
                    Log.d(TAG, "Flow2 $user")
                }
            }

            launch {
                simpleFlow().collect { user ->
                    Log.d(TAG, "Flow3 $user")
                }
            }
        }
    }

    private fun simpleFlow() : Flow<String> = flow {
        userList.forEach { user ->
            emit(user)
            delay(500)
        }
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