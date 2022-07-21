package com.acs.ahadumonitor.di

import com.acs.ahadumonitor.feature_users.domain.use_cases.UpdateHost
import com.acs.ahadumonitor.feature_users.network.HostPingService
import com.acs.ahadumonitor.feature_users.network.model.HostNetworkMapper
import com.acs.ahadumonitor.feature_users.network.repository.HostRepository
import com.acs.ahadumonitor.feature_users.network.repository.HostRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHostRepository(
        hostPingService: HostPingService,
        hostNetworkMapper: HostNetworkMapper
    ): HostRepository {
        return HostRepository_Impl(
            hostPingService = hostPingService,
            hostNetworkMapper = hostNetworkMapper
        )
    }
}