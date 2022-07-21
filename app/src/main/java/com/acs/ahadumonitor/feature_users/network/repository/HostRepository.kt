package com.acs.ahadumonitor.feature_users.network.repository

import com.acs.ahadumonitor.feature_users.domain.model.User


interface HostRepository {
    suspend fun postPing(urls: List<String>): List<User>
}