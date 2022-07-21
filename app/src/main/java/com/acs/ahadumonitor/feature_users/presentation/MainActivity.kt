package com.acs.ahadumonitor.feature_users.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.acs.ahadumonitor.feature_users.network.HostPingService
import com.acs.ahadumonitor.ui.theme.AhaduMonitorTheme
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val service  = Retrofit.Builder()
//            .baseUrl("http://192.168.8.102:1994")
//            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//            .build()
//            .create(HostPingService::class.java)
//        CoroutineScope(IO).launch {
//            val result = service.postPing(listOf("10.20.0.21", "10.1.11.38"))
//            Log.d("ping result", "reult: ${result.result}")
//        }
        setContent {
            AhaduMonitorTheme {
                Navigation()
            }
        }
    }
}
