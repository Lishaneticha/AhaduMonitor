package com.acs.ahadumonitor.feature_users.network.repository

import android.util.Log
import com.acs.ahadumonitor.feature_users.domain.model.User
import com.acs.ahadumonitor.feature_users.network.HostPingService
import com.acs.ahadumonitor.feature_users.network.model.HostNetworkMapper
import com.acs.ahadumonitor.feature_users.domain.use_cases.UpdateHost
import javax.inject.Inject

class HostRepository_Impl (
    private val hostPingService: HostPingService,
    private val hostNetworkMapper: HostNetworkMapper,
): HostRepository {
    override suspend fun postPing(urls: List<String>): List<User> {
        var result = emptyList<User>()
        return try{
            result = hostNetworkMapper.fromEntityList(hostPingService.postPing(urls).result)
            result
        }catch (e: Exception){
            println("ping error: ${e.message}")
            if (e.message.equals("timeout")) {
                println("ping error: $result")
                result
            }
            else
                emptyList()
        }

    }
}