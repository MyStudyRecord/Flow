package com.pss.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.*

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

        //Flow 여러번 collect 방법
/*        CoroutineScope(IO).launch {
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
        }*/

        //Flow Builder
/*        CoroutineScope(IO).launch {
            launch {
                flowUserList.collect{ user ->
                    Log.d(TAG, "Flow2 $user")
                }
            }
            launch {
                userList.asFlow().collect{ user ->
                    Log.d(TAG, "Flow2 $user")
                }
            }
        }*/

        //Flow cancel
/*        CoroutineScope(IO).launch {
            launch {
                //권장 X
            *//*    withTimeoutOrNull(5000){
                    simpleFlow().collect{ user ->
                        Log.d(TAG, "Flow1 $user")
                    }
                }*//*

                simpleFlow().collect{ user ->
                    Log.d(TAG, "Flow1 $user")
                }
            }
        }*/
        //뒤로가기로 앱을 나갈 때 실행 종료 됨
/*        lifecycleScope.launch(Dispatchers.IO) {
            simpleFlow().collect{ user ->
                Log.d(TAG, "Flow1 $user")
            }
        }*/

    }

    private fun simpleFlow() : Flow<String> = flow {
        userList.forEach { user ->
            emit(user)
            delay(1500)
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