package com.acs.ahadumonitor.feature_users.network

import com.acs.ahadumonitor.feature_users.network.response.HostPingResult
import retrofit2.http.Query
import retrofit2.http.POST

interface HostPingService {
    @POST("/ping")
    suspend fun postPing(
        @Query("urls") urls: List<String>
    ): HostPingResult
}